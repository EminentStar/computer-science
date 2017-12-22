import unittest
from search import binary_search


class TestSearch(unittest.TestCase):
    def setUp(self):
        self.a = [0, 1, 2, 3, 4, 5]
    
    def tearDown(self):
        pass
    
    def test_binary_search(self):
        expected_01 = -1
        result_01 = binary_search(self.a, 6, 0, len(self.a)-1)

        expected_02 = 5
        result_02 = binary_search(self.a, 5, 0, len(self.a)-1)

        expected_03 = 4
        result_03 = binary_search(self.a, 4, 0, len(self.a)-1)

        expected_04 = 3
        result_04 = binary_search(self.a, 3, 0, len(self.a)-1)

        expected_05 = 2
        result_05 = binary_search(self.a, 2, 0, len(self.a)-1)

        expected_06 = 1
        result_06 = binary_search(self.a, 1, 0, len(self.a)-1)

        expected_07 = 0
        result_07 = binary_search(self.a, 0, 0, len(self.a)-1)

        expected_08 = -1
        result_08 = binary_search(self.a, 9, 0, len(self.a)-1)

        self.assertEqual(expected_01, result_01)
        self.assertEqual(expected_02, result_02)
        self.assertEqual(expected_03, result_03)
        self.assertEqual(expected_04, result_04)
        self.assertEqual(expected_05, result_05)
        self.assertEqual(expected_06, result_06)
        self.assertEqual(expected_07, result_07)
        self.assertEqual(expected_08, result_08)

if __name__ == '__main__':
    unittest.main()
