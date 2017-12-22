#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>

#define ALU_SIGNAL_AND 0b0000
#define ALU_SIGNAL_OR 0b0001
#define ALU_SIGNAL_ADD 0b0010
#define ALU_SIGNAL_SUB 0b0110
#define ALU_SIGNAL_SLT 0b0111
#define ALU_SIGNAL_NOR 0b1100
#define NOT_EXIST_ALU_SIGNAL 0b1111

/**************************************/

struct Control
{
	unsigned char RegDst;
	unsigned char Jump;
	unsigned char Branch;
	unsigned char MemRead;
	unsigned char MemtoReg;
	unsigned char ALUOp;
	unsigned char MemWrite;
	unsigned char ALUSrc;
	unsigned char RegWrite;
};

struct Reg_Read
{
	unsigned int Read_data_1;
	unsigned int Read_data_2;
};

struct ALU
{
	unsigned char zero; // 1: enable, 0: disable
	unsigned int ALU_result;
};

struct Control control;
struct Reg_Read reg_read;
struct ALU alu;
struct ALU add_alu;
unsigned int mem[64] = { 0 };
unsigned int reg[32] = { 0 };

/**************************************/


unsigned int Add(unsigned int input01, unsigned int input02);
unsigned int Subtract(unsigned int input01, unsigned int input02);
unsigned int And(unsigned int input01, unsigned int input02);
unsigned int Or(unsigned int input01, unsigned int input02);
unsigned int SetLessThan(unsigned int input01, unsigned int input02);
unsigned int Mux(unsigned char control_signal, unsigned int deasserted, unsigned int asserted);
unsigned int Inst_Fetch(unsigned int addr);

void Read_Regs(unsigned int read_reg01, unsigned int read_reg02);
void Control_Unit(unsigned int inst_31_26);
unsigned int ALU_Control_Unit(unsigned int opcode, unsigned char ALUOp);

unsigned int Sign_Extend(unsigned int inst_16);
unsigned int Shift_Left_2(unsigned int inst);

void ALU_Operation(unsigned char alu_control_signal, unsigned int input01, unsigned int input02);
void ALU_Add_operation(struct ALU* alu, unsigned int input01, unsigned int input02);

unsigned int Data_Memory_Unit(unsigned char memWrite, unsigned char memRead, unsigned int addr, unsigned int write_data);

void Write_Reg(unsigned char regWrite, unsigned int write_reg, unsigned int write_data);

void print_reg_mem(void);

/**************************************/

int main(int argc, char** argv)
{
	unsigned int pc = 0;
	FILE *fp;
	unsigned int inst = 0;
	unsigned int inst_31_26 = 0;
	unsigned int inst_25_21 = 0;
	unsigned int inst_20_16 = 0;
	unsigned int inst_15_11 = 0;
	unsigned int inst_15_0 = 0;
	unsigned int inst_ext_32 = 0;
	unsigned int inst_ext_shift = 0;
	unsigned int pc_add_4 = 0;
	unsigned int pc_add_inst = 0;
	unsigned int mux_result = 0;
	unsigned char ALU_control = 0;
	unsigned int inst_25_0 = 0;
	unsigned int jump_addr = 0;
	unsigned int mem_result = 0;
	unsigned int mux_result02 = 0;
	int total_cycle = 0;
	
	// register initialization
	/**************************************/
	reg[8] = 41621;
	reg[9] = 41621;
	reg[16] = 40;
	/**************************************/

	// memory initialization
	/**************************************/
	mem[40] = 3578;

	if ( !(fp = fopen(argv[1], "r")) )
	{
		printf("error: file open fail !!\n");
		exit(1);
	}

	while (feof(fp) == false)
	{
		fscanf(fp, "%x", &inst);
		mem[pc] = inst;
		pc = pc + 4;
	}

	/**************************************/

	// control initialization
	/**************************************/
	control.RegDst = 0;
	control.Jump = 0;
	control.Branch = 0;
	control.MemRead = 0;
	control.ALUOp = 0;
	control.MemWrite = 0;
	control.ALUSrc = 0;
	control.RegWrite = 0;
	/**************************************/

	print_reg_mem();

	printf("\n ***** Processor START !!! ***** \n");

	pc = 0;

	while (pc < 64)
	{
		// initialize control
		control.RegDst = 0;
		control.Jump = 0;
		control.Branch = 0;
		control.MemRead = 0;
		control.ALUOp = 0;
		control.MemWrite = 0;
		control.ALUSrc = 0;
		control.RegWrite = 0;
		control.MemtoReg = 0;

		// pc +4
		pc_add_4 = Add(pc, 4);

		// instruction fetch
		inst = Inst_Fetch(pc);
		printf("Instruction = %08x \n", inst);

		// instruction decode
		inst_31_26 = inst >> 26;
		inst_25_21 = (inst & 0x03e00000) >> 21;
		inst_20_16 = (inst & 0x001f0000) >> 16;
		inst_15_11 = (inst & 0x0000f800) >> 11;
		inst_15_0 = inst & 0x0000ffff;
		inst_25_0 = inst & 0x03ffffff;

		/********************************/
		// implementation

		// 1. register read
		Read_Regs(inst_25_21, inst_20_16);

		// 2. create control signal
		Control_Unit(inst_31_26);
		
		// 3. create ALU control signal
		ALU_control = ALU_Control_Unit(inst_15_0 & 0x003f, control.ALUOp);

		// 4. ALU
		inst_ext_32 = Sign_Extend(inst_15_0);
		inst_ext_shift = Shift_Left_2(inst_ext_32);

		ALU_Operation(ALU_control, reg_read.Read_data_1, Mux(control.ALUSrc, reg_read.Read_data_2, inst_ext_32));
		ALU_Add_operation(&add_alu, pc_add_4, inst_ext_shift);
		
		// 5. memory access
		mem_result = Data_Memory_Unit(control.MemWrite, control.MemRead, alu.ALU_result, reg_read.Read_data_2);
		
		// 6. register write
		Write_Reg(control.RegWrite,
			Mux(control.RegDst, inst_20_16, inst_15_11), 
			Mux(control.MemtoReg, alu.ALU_result, mem_result)
		);

		jump_addr = Add(pc_add_4 & 0xf0000000, Shift_Left_2(inst_25_0));
		pc = Mux(control.Jump, 
			Mux(And(control.Branch, alu.zero), pc_add_4, add_alu.ALU_result), 
			jump_addr
		);
		/********************************/

		total_cycle++;

		// result
		/********************************/
		printf("PC : %d \n", pc);
		printf("Total cycle : %d \n", total_cycle);
		print_reg_mem();
		/********************************/

		//system("pause");
	}

	printf("\n ***** Processor END !!! ***** \n");
	
	return 0;
}

unsigned int Sign_Extend(unsigned int inst_16)
{
	unsigned int inst_32 = 0;
	if ((inst_16 & 0x00008000)) // minus
	{
		inst_32 = inst_16 | 0xffff0000;
	}
	else // plus
	{
		inst_32 = inst_16;
	}
	
	return inst_32;
}

unsigned int Shift_Left_2(unsigned int inst)
{
	return inst << 2;
}

void print_reg_mem(void)
{
	int reg_index = 0;
	int mem_index = 0;

	printf("\n===================== REGISTER =====================\n");

	for (reg_index = 0; reg_index < 8; reg_index++)
	{
		printf("reg[%02d] = %08d        reg[%02d] = %08d        reg[%02d] = %08d        reg[%02d] = %08d \n",
			reg_index, reg[reg_index], reg_index+8, reg[reg_index+8], reg_index+16, reg[reg_index+16], reg_index+24, reg[reg_index+24] );
	}
	
	printf("===================== REGISTER =====================\n");

	printf("\n===================== MEMORY =====================\n");

	for (mem_index = 0; mem_index < 32; mem_index = mem_index + 4)
	{
		printf("mem[%02d] = %012d        mem[%02d] = %012d \n",
			mem_index, mem[mem_index], mem_index + 32, mem[mem_index + 32]);
	}
	printf("===================== MEMORY =====================\n");
}

unsigned int Add(unsigned int input01, unsigned int input02){
    return input01 + input02;
}

unsigned int Subtract(unsigned int input01, unsigned int input02){
    return input01 - input02;
}

unsigned int And(unsigned int input01, unsigned int input02){
    return input01 & input02;
}

unsigned int Or(unsigned int input01, unsigned int input02){
    return input01 | input02;
}

unsigned int SetLessThan(unsigned int input01, unsigned int input02){
	if(input01 < input02){
		return 1;
	}else{
		return 0;
	}
}

unsigned int Inst_Fetch(unsigned int addr){
    return mem[addr];
}

void Control_Unit(unsigned int inst_31_26){
	if(inst_31_26 == 0x00){ // R-type instruction
		printf(">> ADD\n");
		control.RegDst = 1;
		control.ALUSrc = 0;
		control.MemtoReg = 0;
		control.RegWrite = 1;
		control.MemRead = 0;
		control.MemWrite = 0;
		control.Branch = 0;
		control.ALUOp = 10;
		control.Jump = 0;
	}else if(inst_31_26 == 0x23){ // load instrunction
		printf(">> LOAD\n");
		control.RegDst = 0;
		control.ALUSrc = 1;
		control.MemtoReg = 1;
		control.RegWrite = 1;
		control.MemRead = 1;
		control.MemWrite = 0;
		control.Branch = 0;
		control.ALUOp = 00;
		control.Jump = 0;
	}else if(inst_31_26 == 0x2b){ // store instrunction
		printf(">> STORE\n");
		// control.RegDst = 0;
		control.ALUSrc = 1;
		// control.MemtoReg = 1;
		control.RegWrite = 0;
		control.MemRead = 0;
		control.MemWrite = 1;
		control.Branch = 0;
		control.ALUOp = 00;
		control.Jump = 0;
	}else if(inst_31_26 == 0x04){ // branch instruction
		printf(">> BEQ\n");
		// control.RegDst = 0;
		control.ALUSrc = 0;
		// control.MemtoReg = 1;
		control.RegWrite = 0;
		control.MemRead = 0;
		control.MemWrite = 0;
		control.Branch = 1;
		control.ALUOp = 01;
		control.Jump = 0;
	}else if(inst_31_26 == 0x02){ // jump instrunction
		printf(">> JUMP\n");
		control.Jump = 1;
	}
}

void Read_Regs(unsigned int read_reg01, unsigned int read_reg02){
	reg_read.Read_data_1 = reg[read_reg01];
	reg_read.Read_data_2 = reg[read_reg02];
}

void Write_Reg(unsigned char regWrite, unsigned int write_reg, unsigned int write_data){
	if(regWrite == 1){
		reg[write_reg] = write_data;
	}
}

unsigned int Mux(unsigned char control_signal, unsigned int deasserted, unsigned int asserted){
	if(control_signal == 1){
		return asserted;
	}else{
		return deasserted;
	}
}

unsigned int ALU_Control_Unit(unsigned int opcode, unsigned char ALUOp){
	unsigned int funct_3_0 = opcode & 0x0f;

	if(ALUOp == 00){ // lw or sw
		return ALU_SIGNAL_ADD;
	}else if(ALUOp == 01){ // branch
		return ALU_SIGNAL_SUB;
	}else{ // r-type
		if(funct_3_0 == 0b0000){
			return ALU_SIGNAL_ADD;
		}else if(funct_3_0 == 0b0010){
			return ALU_SIGNAL_SUB;
		}else if(funct_3_0 == 0b0100){
			return ALU_SIGNAL_AND;
		}else if(funct_3_0 == 0b0101){
			return ALU_SIGNAL_OR;
		}else if(funct_3_0 == 0b1010){
			return ALU_SIGNAL_SLT;
		}else{
			return NOT_EXIST_ALU_SIGNAL;
		}
	}
}

void ALU_Add_operation(struct ALU* alu, unsigned int input01, unsigned int input02){
	alu->ALU_result = Add(input01, input02);
}

void ALU_Operation(unsigned char alu_control_signal, unsigned int input01, unsigned int input02){
	unsigned int ret_value = 0;
	
	switch(alu_control_signal){
		case ALU_SIGNAL_ADD:
			ret_value = Add(input01, input02);
			break;
		case ALU_SIGNAL_SUB:
			ret_value = Subtract(input01, input02);
			break;
		case ALU_SIGNAL_AND:
			ret_value = And(input01, input02);
			break;
		case ALU_SIGNAL_OR:
			ret_value = Or(input01, input02);
			break;
		case ALU_SIGNAL_SLT:
			ret_value = SetLessThan(input01, input02);
			break;
		default:
			break;
	}

	alu.ALU_result = ret_value;
	if(alu.ALU_result == 0){
		alu.zero = 1;
	}
}


unsigned int Data_Memory_Unit(unsigned char memWrite, unsigned char memRead, unsigned int addr, unsigned int write_data){
	if(memWrite == 1){
		mem[addr] = write_data;
	}

	if(memRead == 1){
		return mem[addr];
	}

	return 0;
}