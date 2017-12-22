from string_matching import get_pi
from string_matching import kmp


def main():
    t = input()
    p = input()
    matches = kmp(t, p)

    print(len(matches))
    for m in matches:
        print(m+1)


if __name__ == '__main__':
    main()
