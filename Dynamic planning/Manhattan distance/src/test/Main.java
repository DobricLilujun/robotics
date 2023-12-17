package test;

import java.util.ArrayList;
import java.util.LinkedList;

//import tests.DrawLine;

public class Main extends Astar {

	public static void main(String[] args) {

		// Define the obtstacles in the graph
		int obs_error[][] = { { 1, 1 },
				{ 2, 1 },
				{ 3, 1 },
				{ 4, 1 },
				{ 5, 1 },
				{ 6, 1 },
				{ 7, 1 },
				{ 8, 1 },
				{ 9, 1 },
				{ 10, 1 },
				{ 11, 1 },
				{ 12, 1 },
				{ 13, 1 },
				{ 14, 1 },
				{ 15, 1 },
				{ 16, 1 },
				{ 17, 1 },
				{ 18, 1 },
				{ 19, 1 },
				{ 20, 1 },
				{ 21, 1 },
				{ 22, 1 },
				{ 23, 1 },
				{ 24, 1 },
				{ 25, 1 },
				{ 26, 1 },
				{ 27, 1 },
				{ 28, 1 },
				{ 29, 1 },
				{ 30, 1 },
				{ 31, 1 },
				{ 32, 1 },
				{ 33, 1 },
				{ 34, 1 },
				{ 35, 1 },
				{ 36, 1 },
				{ 37, 1 },
				{ 38, 1 },
				{ 39, 1 },
				{ 40, 1 },
				{ 41, 1 },
				{ 42, 1 },
				{ 43, 1 },
				{ 44, 1 },
				{ 45, 1 },
				{ 46, 1 },
				{ 47, 1 },
				{ 48, 1 },
				{ 49, 1 },
				{ 50, 1 },
				{ 51, 1 },
				{ 52, 1 },
				{ 53, 1 },
				{ 54, 1 },
				{ 55, 1 },
				{ 56, 1 },
				{ 57, 1 },
				{ 58, 1 },
				{ 59, 1 },
				{ 60, 1 },
				{ 61, 1 },
				{ 1, 2 },
				{ 9, 2 },
				{ 13, 2 },
				{ 23, 2 },
				{ 45, 2 },
				{ 51, 2 },
				{ 55, 2 },
				{ 61, 2 },
				{ 1, 3 },
				{ 2, 3 },
				{ 3, 3 },
				{ 4, 3 },
				{ 5, 3 },
				{ 6, 3 },
				{ 7, 3 },
				{ 9, 3 },
				{ 11, 3 },
				{ 12, 3 },
				{ 13, 3 },
				{ 15, 3 },
				{ 17, 3 },
				{ 18, 3 },
				{ 19, 3 },
				{ 20, 3 },
				{ 21, 3 },
				{ 22, 3 },
				{ 23, 3 },
				{ 25, 3 },
				{ 26, 3 },
				{ 27, 3 },
				{ 28, 3 },
				{ 29, 3 },
				{ 30, 3 },
				{ 31, 3 },
				{ 32, 3 },
				{ 33, 3 },
				{ 34, 3 },
				{ 35, 3 },
				{ 37, 3 },
				{ 38, 3 },
				{ 39, 3 },
				{ 40, 3 },
				{ 41, 3 },
				{ 42, 3 },
				{ 43, 3 },
				{ 45, 3 },
				{ 47, 3 },
				{ 48, 3 },
				{ 49, 3 },
				{ 51, 3 },
				{ 53, 3 },
				{ 55, 3 },
				{ 57, 3 },
				{ 58, 3 },
				{ 59, 3 },
				{ 61, 3 },
				{ 1, 4 },
				{ 9, 4 },
				{ 15, 4 },
				{ 25, 4 },
				{ 27, 4 },
				{ 37, 4 },
				{ 41, 4 },
				{ 45, 4 },
				{ 47, 4 },
				{ 51, 4 },
				{ 53, 4 },
				{ 55, 4 },
				{ 57, 4 },
				{ 59, 4 },
				{ 61, 4 },
				{ 1, 5 },
				{ 3, 5 },
				{ 4, 5 },
				{ 5, 5 },
				{ 6, 5 },
				{ 7, 5 },
				{ 8, 5 },
				{ 9, 5 },
				{ 11, 5 },
				{ 12, 5 },
				{ 13, 5 },
				{ 14, 5 },
				{ 15, 5 },
				{ 16, 5 },
				{ 17, 5 },
				{ 18, 5 },
				{ 19, 5 },
				{ 20, 5 },
				{ 21, 5 },
				{ 22, 5 },
				{ 23, 5 },
				{ 24, 5 },
				{ 25, 5 },
				{ 27, 5 },
				{ 29, 5 },
				{ 30, 5 },
				{ 31, 5 },
				{ 32, 5 },
				{ 33, 5 },
				{ 34, 5 },
				{ 35, 5 },
				{ 36, 5 },
				{ 37, 5 },
				{ 39, 5 },
				{ 41, 5 },
				{ 42, 5 },
				{ 43, 5 },
				{ 45, 5 },
				{ 47, 5 },
				{ 48, 5 },
				{ 49, 5 },
				{ 51, 5 },
				{ 53, 5 },
				{ 55, 5 },
				{ 57, 5 },
				{ 59, 5 },
				{ 61, 5 },
				{ 1, 6 },
				{ 3, 6 },
				{ 7, 6 },
				{ 11, 6 },
				{ 15, 6 },
				{ 27, 6 },
				{ 29, 6 },
				{ 39, 6 },
				{ 43, 6 },
				{ 45, 6 },
				{ 49, 6 },
				{ 53, 6 },
				{ 55, 6 },
				{ 57, 6 },
				{ 59, 6 },
				{ 61, 6 },
				{ 1, 7 },
				{ 3, 7 },
				{ 4, 7 },
				{ 5, 7 },
				{ 7, 7 },
				{ 9, 7 },
				{ 10, 7 },
				{ 11, 7 },
				{ 13, 7 },
				{ 15, 7 },
				{ 17, 7 },
				{ 19, 7 },
				{ 20, 7 },
				{ 21, 7 },
				{ 22, 7 },
				{ 23, 7 },
				{ 24, 7 },
				{ 25, 7 },
				{ 27, 7 },
				{ 29, 7 },
				{ 31, 7 },
				{ 32, 7 },
				{ 33, 7 },
				{ 34, 7 },
				{ 35, 7 },
				{ 36, 7 },
				{ 37, 7 },
				{ 38, 7 },
				{ 39, 7 },
				{ 40, 7 },
				{ 41, 7 },
				{ 43, 7 },
				{ 45, 7 },
				{ 46, 7 },
				{ 47, 7 },
				{ 49, 7 },
				{ 50, 7 },
				{ 51, 7 },
				{ 52, 7 },
				{ 53, 7 },
				{ 54, 7 },
				{ 55, 7 },
				{ 57, 7 },
				{ 59, 7 },
				{ 61, 7 },
				{ 1, 8 },
				{ 5, 8 },
				{ 7, 8 },
				{ 11, 8 },
				{ 13, 8 },
				{ 17, 8 },
				{ 23, 8 },
				{ 27, 8 },
				{ 29, 8 },
				{ 31, 8 },
				{ 39, 8 },
				{ 43, 8 },
				{ 49, 8 },
				{ 57, 8 },
				{ 59, 8 },
				{ 61, 8 },
				{ 1, 9 },
				{ 2, 9 },
				{ 3, 9 },
				{ 5, 9 },
				{ 7, 9 },
				{ 8, 9 },
				{ 9, 9 },
				{ 11, 9 },
				{ 12, 9 },
				{ 13, 9 },
				{ 14, 9 },
				{ 15, 9 },
				{ 16, 9 },
				{ 17, 9 },
				{ 18, 9 },
				{ 19, 9 },
				{ 20, 9 },
				{ 21, 9 },
				{ 23, 9 },
				{ 25, 9 },
				{ 26, 9 },
				{ 27, 9 },
				{ 29, 9 },
				{ 31, 9 },
				{ 32, 9 },
				{ 33, 9 },
				{ 34, 9 },
				{ 35, 9 },
				{ 36, 9 },
				{ 37, 9 },
				{ 39, 9 },
				{ 41, 9 },
				{ 42, 9 },
				{ 43, 9 },
				{ 45, 9 },
				{ 46, 9 },
				{ 47, 9 },
				{ 48, 9 },
				{ 49, 9 },
				{ 51, 9 },
				{ 52, 9 },
				{ 53, 9 },
				{ 54, 9 },
				{ 55, 9 },
				{ 56, 9 },
				{ 57, 9 },
				{ 59, 9 },
				{ 61, 9 },
				{ 1, 10 },
				{ 3, 10 },
				{ 5, 10 },
				{ 9, 10 },
				{ 13, 10 },
				{ 17, 10 },
				{ 21, 10 },
				{ 23, 10 },
				{ 27, 10 },
				{ 39, 10 },
				{ 43, 10 },
				{ 45, 10 },
				{ 51, 10 },
				{ 59, 10 },
				{ 61, 10 },
				{ 1, 11 },
				{ 3, 11 },
				{ 5, 11 },
				{ 7, 11 },
				{ 8, 11 },
				{ 9, 11 },
				{ 10, 11 },
				{ 11, 11 },
				{ 13, 11 },
				{ 15, 11 },
				{ 17, 11 },
				{ 19, 11 },
				{ 21, 11 },
				{ 23, 11 },
				{ 24, 11 },
				{ 25, 11 },
				{ 26, 11 },
				{ 27, 11 },
				{ 28, 11 },
				{ 29, 11 },
				{ 30, 11 },
				{ 31, 11 },
				{ 32, 11 },
				{ 33, 11 },
				{ 34, 11 },
				{ 35, 11 },
				{ 36, 11 },
				{ 37, 11 },
				{ 39, 11 },
				{ 40, 11 },
				{ 41, 11 },
				{ 43, 11 },
				{ 45, 11 },
				{ 47, 11 },
				{ 48, 11 },
				{ 49, 11 },
				{ 50, 11 },
				{ 51, 11 },
				{ 52, 11 },
				{ 53, 11 },
				{ 54, 11 },
				{ 55, 11 },
				{ 57, 11 },
				{ 59, 11 },
				{ 61, 11 },
				{ 1, 12 },
				{ 3, 12 },
				{ 5, 12 },
				{ 7, 12 },
				{ 15, 12 },
				{ 19, 12 },
				{ 21, 12 },
				{ 23, 12 },
				{ 37, 12 },
				{ 41, 12 },
				{ 43, 12 },
				{ 45, 12 },
				{ 49, 12 },
				{ 57, 12 },
				{ 59, 12 },
				{ 61, 12 },
				{ 1, 13 },
				{ 3, 13 },
				{ 5, 13 },
				{ 7, 13 },
				{ 9, 13 },
				{ 10, 13 },
				{ 11, 13 },
				{ 12, 13 },
				{ 13, 13 },
				{ 14, 13 },
				{ 15, 13 },
				{ 16, 13 },
				{ 17, 13 },
				{ 18, 13 },
				{ 19, 13 },
				{ 21, 13 },
				{ 23, 13 },
				{ 25, 13 },
				{ 26, 13 },
				{ 27, 13 },
				{ 28, 13 },
				{ 29, 13 },
				{ 30, 13 },
				{ 31, 13 },
				{ 32, 13 },
				{ 33, 13 },
				{ 34, 13 },
				{ 35, 13 },
				{ 37, 13 },
				{ 38, 13 },
				{ 39, 13 },
				{ 41, 13 },
				{ 43, 13 },
				{ 44, 13 },
				{ 45, 13 },
				{ 46, 13 },
				{ 47, 13 },
				{ 49, 13 },
				{ 50, 13 },
				{ 51, 13 },
				{ 53, 13 },
				{ 54, 13 },
				{ 55, 13 },
				{ 57, 13 },
				{ 58, 13 },
				{ 59, 13 },
				{ 61, 13 },
				{ 1, 14 },
				{ 3, 14 },
				{ 5, 14 },
				{ 11, 14 },
				{ 19, 14 },
				{ 23, 14 },
				{ 27, 14 },
				{ 33, 14 },
				{ 37, 14 },
				{ 39, 14 },
				{ 41, 14 },
				{ 53, 14 },
				{ 57, 14 },
				{ 61, 14 },
				{ 1, 15 },
				{ 3, 15 },
				{ 5, 15 },
				{ 6, 15 },
				{ 7, 15 },
				{ 8, 15 },
				{ 9, 15 },
				{ 11, 15 },
				{ 13, 15 },
				{ 14, 15 },
				{ 15, 15 },
				{ 16, 15 },
				{ 17, 15 },
				{ 19, 15 },
				{ 20, 15 },
				{ 21, 15 },
				{ 22, 15 },
				{ 23, 15 },
				{ 24, 15 },
				{ 25, 15 },
				{ 27, 15 },
				{ 29, 15 },
				{ 31, 15 },
				{ 32, 15 },
				{ 33, 15 },
				{ 35, 15 },
				{ 36, 15 },
				{ 37, 15 },
				{ 39, 15 },
				{ 41, 15 },
				{ 42, 15 },
				{ 43, 15 },
				{ 44, 15 },
				{ 45, 15 },
				{ 46, 15 },
				{ 47, 15 },
				{ 48, 15 },
				{ 49, 15 },
				{ 50, 15 },
				{ 51, 15 },
				{ 52, 15 },
				{ 53, 15 },
				{ 54, 15 },
				{ 55, 15 },
				{ 56, 15 },
				{ 57, 15 },
				{ 59, 15 },
				{ 61, 15 },
				{ 1, 16 },
				{ 3, 16 },
				{ 7, 16 },
				{ 11, 16 },
				{ 13, 16 },
				{ 17, 16 },
				{ 27, 16 },
				{ 29, 16 },
				{ 31, 16 },
				{ 35, 16 },
				{ 37, 16 },
				{ 39, 16 },
				{ 41, 16 },
				{ 45, 16 },
				{ 59, 16 },
				{ 61, 16 },
				{ 1, 17 },
				{ 3, 17 },
				{ 4, 17 },
				{ 5, 17 },
				{ 7, 17 },
				{ 8, 17 },
				{ 9, 17 },
				{ 10, 17 },
				{ 11, 17 },
				{ 13, 17 },
				{ 15, 17 },
				{ 17, 17 },
				{ 18, 17 },
				{ 19, 17 },
				{ 20, 17 },
				{ 21, 17 },
				{ 22, 17 },
				{ 23, 17 },
				{ 24, 17 },
				{ 25, 17 },
				{ 26, 17 },
				{ 27, 17 },
				{ 29, 17 },
				{ 31, 17 },
				{ 33, 17 },
				{ 34, 17 },
				{ 35, 17 },
				{ 37, 17 },
				{ 39, 17 },
				{ 41, 17 },
				{ 43, 17 },
				{ 44, 17 },
				{ 45, 17 },
				{ 47, 17 },
				{ 48, 17 },
				{ 49, 17 },
				{ 50, 17 },
				{ 51, 17 },
				{ 52, 17 },
				{ 53, 17 },
				{ 54, 17 },
				{ 55, 17 },
				{ 56, 17 },
				{ 57, 17 },
				{ 58, 17 },
				{ 59, 17 },
				{ 61, 17 },
				{ 1, 18 },
				{ 5, 18 },
				{ 13, 18 },
				{ 15, 18 },
				{ 17, 18 },
				{ 19, 18 },
				{ 27, 18 },
				{ 29, 18 },
				{ 31, 18 },
				{ 33, 18 },
				{ 39, 18 },
				{ 43, 18 },
				{ 47, 18 },
				{ 51, 18 },
				{ 57, 18 },
				{ 61, 18 },
				{ 1, 19 },
				{ 3, 19 },
				{ 5, 19 },
				{ 6, 19 },
				{ 7, 19 },
				{ 8, 19 },
				{ 9, 19 },
				{ 10, 19 },
				{ 11, 19 },
				{ 12, 19 },
				{ 13, 19 },
				{ 15, 19 },
				{ 17, 19 },
				{ 19, 19 },
				{ 21, 19 },
				{ 22, 19 },
				{ 23, 19 },
				{ 24, 19 },
				{ 25, 19 },
				{ 27, 19 },
				{ 29, 19 },
				{ 31, 19 },
				{ 33, 19 },
				{ 34, 19 },
				{ 35, 19 },
				{ 36, 19 },
				{ 37, 19 },
				{ 39, 19 },
				{ 40, 19 },
				{ 41, 19 },
				{ 43, 19 },
				{ 45, 19 },
				{ 46, 19 },
				{ 47, 19 },
				{ 49, 19 },
				{ 51, 19 },
				{ 53, 19 },
				{ 54, 19 },
				{ 55, 19 },
				{ 56, 19 },
				{ 57, 19 },
				{ 59, 19 },
				{ 60, 19 },
				{ 61, 19 },
				{ 1, 20 },
				{ 3, 20 },
				{ 5, 20 },
				{ 15, 20 },
				{ 17, 20 },
				{ 21, 20 },
				{ 27, 20 },
				{ 29, 20 },
				{ 33, 20 },
				{ 37, 20 },
				{ 43, 20 },
				{ 45, 20 },
				{ 49, 20 },
				{ 53, 20 },
				{ 59, 20 },
				{ 61, 20 },
				{ 1, 21 },
				{ 3, 21 },
				{ 5, 21 },
				{ 7, 21 },
				{ 9, 21 },
				{ 10, 21 },
				{ 11, 21 },
				{ 12, 21 },
				{ 13, 21 },
				{ 14, 21 },
				{ 15, 21 },
				{ 17, 21 },
				{ 18, 21 },
				{ 19, 21 },
				{ 20, 21 },
				{ 21, 21 },
				{ 23, 21 },
				{ 24, 21 },
				{ 25, 21 },
				{ 27, 21 },
				{ 29, 21 },
				{ 30, 21 },
				{ 31, 21 },
				{ 32, 21 },
				{ 33, 21 },
				{ 35, 21 },
				{ 37, 21 },
				{ 38, 21 },
				{ 39, 21 },
				{ 40, 21 },
				{ 41, 21 },
				{ 42, 21 },
				{ 43, 21 },
				{ 45, 21 },
				{ 47, 21 },
				{ 49, 21 },
				{ 50, 21 },
				{ 51, 21 },
				{ 53, 21 },
				{ 55, 21 },
				{ 56, 21 },
				{ 57, 21 },
				{ 58, 21 },
				{ 59, 21 },
				{ 61, 21 },
				{ 1, 22 },
				{ 3, 22 },
				{ 7, 22 },
				{ 9, 22 },
				{ 15, 22 },
				{ 17, 22 },
				{ 23, 22 },
				{ 27, 22 },
				{ 29, 22 },
				{ 35, 22 },
				{ 45, 22 },
				{ 47, 22 },
				{ 49, 22 },
				{ 51, 22 },
				{ 53, 22 },
				{ 57, 22 },
				{ 61, 22 },
				{ 1, 23 },
				{ 3, 23 },
				{ 4, 23 },
				{ 5, 23 },
				{ 6, 23 },
				{ 7, 23 },
				{ 9, 23 },
				{ 10, 23 },
				{ 11, 23 },
				{ 12, 23 },
				{ 13, 23 },
				{ 15, 23 },
				{ 17, 23 },
				{ 19, 23 },
				{ 20, 23 },
				{ 21, 23 },
				{ 22, 23 },
				{ 23, 23 },
				{ 25, 23 },
				{ 26, 23 },
				{ 27, 23 },
				{ 29, 23 },
				{ 31, 23 },
				{ 32, 23 },
				{ 33, 23 },
				{ 34, 23 },
				{ 35, 23 },
				{ 36, 23 },
				{ 37, 23 },
				{ 38, 23 },
				{ 39, 23 },
				{ 40, 23 },
				{ 41, 23 },
				{ 42, 23 },
				{ 43, 23 },
				{ 44, 23 },
				{ 45, 23 },
				{ 47, 23 },
				{ 49, 23 },
				{ 51, 23 },
				{ 53, 23 },
				{ 54, 23 },
				{ 55, 23 },
				{ 57, 23 },
				{ 58, 23 },
				{ 59, 23 },
				{ 61, 23 },
				{ 1, 24 },
				{ 7, 24 },
				{ 9, 24 },
				{ 13, 24 },
				{ 19, 24 },
				{ 23, 24 },
				{ 27, 24 },
				{ 29, 24 },
				{ 31, 24 },
				{ 33, 24 },
				{ 41, 24 },
				{ 45, 24 },
				{ 47, 24 },
				{ 49, 24 },
				{ 55, 24 },
				{ 59, 24 },
				{ 61, 24 },
				{ 1, 25 },
				{ 3, 25 },
				{ 4, 25 },
				{ 5, 25 },
				{ 6, 25 },
				{ 7, 25 },
				{ 9, 25 },
				{ 11, 25 },
				{ 13, 25 },
				{ 14, 25 },
				{ 15, 25 },
				{ 16, 25 },
				{ 17, 25 },
				{ 18, 25 },
				{ 19, 25 },
				{ 20, 25 },
				{ 21, 25 },
				{ 23, 25 },
				{ 24, 25 },
				{ 25, 25 },
				{ 27, 25 },
				{ 29, 25 },
				{ 31, 25 },
				{ 33, 25 },
				{ 35, 25 },
				{ 37, 25 },
				{ 38, 25 },
				{ 39, 25 },
				{ 41, 25 },
				{ 43, 25 },
				{ 44, 25 },
				{ 45, 25 },
				{ 47, 25 },
				{ 49, 25 },
				{ 50, 25 },
				{ 51, 25 },
				{ 52, 25 },
				{ 53, 25 },
				{ 54, 25 },
				{ 55, 25 },
				{ 56, 25 },
				{ 57, 25 },
				{ 59, 25 },
				{ 61, 25 },
				{ 1, 26 },
				{ 3, 26 },
				{ 9, 26 },
				{ 11, 26 },
				{ 13, 26 },
				{ 21, 26 },
				{ 27, 26 },
				{ 29, 26 },
				{ 31, 26 },
				{ 35, 26 },
				{ 39, 26 },
				{ 41, 26 },
				{ 43, 26 },
				{ 47, 26 },
				{ 57, 26 },
				{ 59, 26 },
				{ 61, 26 },
				{ 1, 27 },
				{ 3, 27 },
				{ 5, 27 },
				{ 6, 27 },
				{ 7, 27 },
				{ 8, 27 },
				{ 9, 27 },
				{ 11, 27 },
				{ 13, 27 },
				{ 15, 27 },
				{ 16, 27 },
				{ 17, 27 },
				{ 18, 27 },
				{ 19, 27 },
				{ 21, 27 },
				{ 23, 27 },
				{ 24, 27 },
				{ 25, 27 },
				{ 26, 27 },
				{ 27, 27 },
				{ 29, 27 },
				{ 31, 27 },
				{ 32, 27 },
				{ 33, 27 },
				{ 35, 27 },
				{ 37, 27 },
				{ 39, 27 },
				{ 41, 27 },
				{ 43, 27 },
				{ 45, 27 },
				{ 46, 27 },
				{ 47, 27 },
				{ 48, 27 },
				{ 49, 27 },
				{ 50, 27 },
				{ 51, 27 },
				{ 52, 27 },
				{ 53, 27 },
				{ 54, 27 },
				{ 55, 27 },
				{ 57, 27 },
				{ 59, 27 },
				{ 61, 27 },
				{ 1, 28 },
				{ 3, 28 },
				{ 11, 28 },
				{ 13, 28 },
				{ 17, 28 },
				{ 21, 28 },
				{ 23, 28 },
				{ 27, 28 },
				{ 29, 28 },
				{ 31, 28 },
				{ 35, 28 },
				{ 37, 28 },
				{ 39, 28 },
				{ 41, 28 },
				{ 43, 28 },
				{ 45, 28 },
				{ 53, 28 },
				{ 55, 28 },
				{ 59, 28 },
				{ 61, 28 },
				{ 1, 29 },
				{ 3, 29 },
				{ 4, 29 },
				{ 5, 29 },
				{ 6, 29 },
				{ 7, 29 },
				{ 8, 29 },
				{ 9, 29 },
				{ 10, 29 },
				{ 11, 29 },
				{ 13, 29 },
				{ 14, 29 },
				{ 15, 29 },
				{ 17, 29 },
				{ 19, 29 },
				{ 20, 29 },
				{ 21, 29 },
				{ 23, 29 },
				{ 25, 29 },
				{ 26, 29 },
				{ 27, 29 },
				{ 29, 29 },
				{ 31, 29 },
				{ 32, 29 },
				{ 33, 29 },
				{ 34, 29 },
				{ 35, 29 },
				{ 36, 29 },
				{ 37, 29 },
				{ 39, 29 },
				{ 41, 29 },
				{ 43, 29 },
				{ 45, 29 },
				{ 46, 29 },
				{ 47, 29 },
				{ 48, 29 },
				{ 49, 29 },
				{ 51, 29 },
				{ 53, 29 },
				{ 55, 29 },
				{ 56, 29 },
				{ 57, 29 },
				{ 58, 29 },
				{ 59, 29 },
				{ 61, 29 },
				{ 1, 30 },
				{ 7, 30 },
				{ 11, 30 },
				{ 17, 30 },
				{ 21, 30 },
				{ 23, 30 },
				{ 25, 30 },
				{ 29, 30 },
				{ 33, 30 },
				{ 37, 30 },
				{ 39, 30 },
				{ 43, 30 },
				{ 51, 30 },
				{ 55, 30 },
				{ 59, 30 },
				{ 61, 30 },
				{ 1, 31 },
				{ 2, 31 },
				{ 3, 31 },
				{ 4, 31 },
				{ 5, 31 },
				{ 7, 31 },
				{ 9, 31 },
				{ 11, 31 },
				{ 12, 31 },
				{ 13, 31 },
				{ 14, 31 },
				{ 15, 31 },
				{ 16, 31 },
				{ 17, 31 },
				{ 18, 31 },
				{ 19, 31 },
				{ 21, 31 },
				{ 23, 31 },
				{ 25, 31 },
				{ 27, 31 },
				{ 28, 31 },
				{ 29, 31 },
				{ 31, 31 },
				{ 33, 31 },
				{ 35, 31 },
				{ 37, 31 },
				{ 39, 31 },
				{ 40, 31 },
				{ 41, 31 },
				{ 42, 31 },
				{ 43, 31 },
				{ 44, 31 },
				{ 45, 31 },
				{ 46, 31 },
				{ 47, 31 },
				{ 48, 31 },
				{ 49, 31 },
				{ 50, 31 },
				{ 51, 31 },
				{ 53, 31 },
				{ 54, 31 },
				{ 55, 31 },
				{ 56, 31 },
				{ 57, 31 },
				{ 59, 31 },
				{ 61, 31 },
				{ 1, 32 },
				{ 5, 32 },
				{ 7, 32 },
				{ 9, 32 },
				{ 11, 32 },
				{ 19, 32 },
				{ 21, 32 },
				{ 25, 32 },
				{ 27, 32 },
				{ 31, 32 },
				{ 33, 32 },
				{ 35, 32 },
				{ 37, 32 },
				{ 49, 32 },
				{ 51, 32 },
				{ 55, 32 },
				{ 61, 32 },
				{ 1, 33 },
				{ 2, 33 },
				{ 3, 33 },
				{ 5, 33 },
				{ 7, 33 },
				{ 9, 33 },
				{ 11, 33 },
				{ 13, 33 },
				{ 15, 33 },
				{ 16, 33 },
				{ 17, 33 },
				{ 18, 33 },
				{ 19, 33 },
				{ 21, 33 },
				{ 22, 33 },
				{ 23, 33 },
				{ 24, 33 },
				{ 25, 33 },
				{ 27, 33 },
				{ 29, 33 },
				{ 30, 33 },
				{ 31, 33 },
				{ 33, 33 },
				{ 35, 33 },
				{ 37, 33 },
				{ 38, 33 },
				{ 39, 33 },
				{ 41, 33 },
				{ 42, 33 },
				{ 43, 33 },
				{ 45, 33 },
				{ 46, 33 },
				{ 47, 33 },
				{ 49, 33 },
				{ 51, 33 },
				{ 52, 33 },
				{ 53, 33 },
				{ 55, 33 },
				{ 57, 33 },
				{ 58, 33 },
				{ 59, 33 },
				{ 61, 33 },
				{ 1, 34 },
				{ 5, 34 },
				{ 7, 34 },
				{ 9, 34 },
				{ 11, 34 },
				{ 13, 34 },
				{ 19, 34 },
				{ 27, 34 },
				{ 31, 34 },
				{ 35, 34 },
				{ 39, 34 },
				{ 41, 34 },
				{ 43, 34 },
				{ 47, 34 },
				{ 53, 34 },
				{ 55, 34 },
				{ 59, 34 },
				{ 61, 34 },
				{ 1, 35 },
				{ 3, 35 },
				{ 4, 35 },
				{ 5, 35 },
				{ 7, 35 },
				{ 8, 35 },
				{ 9, 35 },
				{ 11, 35 },
				{ 13, 35 },
				{ 14, 35 },
				{ 15, 35 },
				{ 16, 35 },
				{ 17, 35 },
				{ 19, 35 },
				{ 20, 35 },
				{ 21, 35 },
				{ 22, 35 },
				{ 23, 35 },
				{ 24, 35 },
				{ 25, 35 },
				{ 26, 35 },
				{ 27, 35 },
				{ 28, 35 },
				{ 29, 35 },
				{ 30, 35 },
				{ 31, 35 },
				{ 32, 35 },
				{ 33, 35 },
				{ 34, 35 },
				{ 35, 35 },
				{ 36, 35 },
				{ 37, 35 },
				{ 39, 35 },
				{ 41, 35 },
				{ 43, 35 },
				{ 44, 35 },
				{ 45, 35 },
				{ 47, 35 },
				{ 48, 35 },
				{ 49, 35 },
				{ 51, 35 },
				{ 52, 35 },
				{ 53, 35 },
				{ 55, 35 },
				{ 57, 35 },
				{ 59, 35 },
				{ 60, 35 },
				{ 61, 35 },
				{ 1, 36 },
				{ 5, 36 },
				{ 7, 36 },
				{ 11, 36 },
				{ 13, 36 },
				{ 15, 36 },
				{ 19, 36 },
				{ 33, 36 },
				{ 39, 36 },
				{ 43, 36 },
				{ 45, 36 },
				{ 47, 36 },
				{ 51, 36 },
				{ 55, 36 },
				{ 57, 36 },
				{ 61, 36 },
				{ 1, 37 },
				{ 3, 37 },
				{ 5, 37 },
				{ 7, 37 },
				{ 9, 37 },
				{ 10, 37 },
				{ 11, 37 },
				{ 13, 37 },
				{ 15, 37 },
				{ 17, 37 },
				{ 19, 37 },
				{ 20, 37 },
				{ 21, 37 },
				{ 22, 37 },
				{ 23, 37 },
				{ 25, 37 },
				{ 27, 37 },
				{ 28, 37 },
				{ 29, 37 },
				{ 30, 37 },
				{ 31, 37 },
				{ 33, 37 },
				{ 35, 37 },
				{ 36, 37 },
				{ 37, 37 },
				{ 38, 37 },
				{ 39, 37 },
				{ 40, 37 },
				{ 41, 37 },
				{ 43, 37 },
				{ 45, 37 },
				{ 47, 37 },
				{ 48, 37 },
				{ 49, 37 },
				{ 50, 37 },
				{ 51, 37 },
				{ 53, 37 },
				{ 54, 37 },
				{ 55, 37 },
				{ 56, 37 },
				{ 57, 37 },
				{ 58, 37 },
				{ 59, 37 },
				{ 61, 37 },
				{ 1, 38 },
				{ 3, 38 },
				{ 7, 38 },
				{ 15, 38 },
				{ 17, 38 },
				{ 19, 38 },
				{ 23, 38 },
				{ 25, 38 },
				{ 29, 38 },
				{ 35, 38 },
				{ 39, 38 },
				{ 43, 38 },
				{ 45, 38 },
				{ 51, 38 },
				{ 53, 38 },
				{ 61, 38 },
				{ 1, 39 },
				{ 3, 39 },
				{ 4, 39 },
				{ 5, 39 },
				{ 6, 39 },
				{ 7, 39 },
				{ 8, 39 },
				{ 9, 39 },
				{ 10, 39 },
				{ 11, 39 },
				{ 12, 39 },
				{ 13, 39 },
				{ 14, 39 },
				{ 15, 39 },
				{ 17, 39 },
				{ 19, 39 },
				{ 21, 39 },
				{ 23, 39 },
				{ 25, 39 },
				{ 26, 39 },
				{ 27, 39 },
				{ 29, 39 },
				{ 30, 39 },
				{ 31, 39 },
				{ 32, 39 },
				{ 33, 39 },
				{ 34, 39 },
				{ 35, 39 },
				{ 36, 39 },
				{ 37, 39 },
				{ 39, 39 },
				{ 41, 39 },
				{ 42, 39 },
				{ 43, 39 },
				{ 45, 39 },
				{ 46, 39 },
				{ 47, 39 },
				{ 49, 39 },
				{ 51, 39 },
				{ 53, 39 },
				{ 55, 39 },
				{ 57, 39 },
				{ 58, 39 },
				{ 59, 39 },
				{ 60, 39 },
				{ 61, 39 },
				{ 1, 40 },
				{ 5, 40 },
				{ 17, 40 },
				{ 19, 40 },
				{ 21, 40 },
				{ 23, 40 },
				{ 27, 40 },
				{ 31, 40 },
				{ 37, 40 },
				{ 39, 40 },
				{ 43, 40 },
				{ 47, 40 },
				{ 49, 40 },
				{ 51, 40 },
				{ 53, 40 },
				{ 55, 40 },
				{ 61, 40 },
				{ 1, 41 },
				{ 2, 41 },
				{ 3, 41 },
				{ 5, 41 },
				{ 6, 41 },
				{ 7, 41 },
				{ 9, 41 },
				{ 10, 41 },
				{ 11, 41 },
				{ 12, 41 },
				{ 13, 41 },
				{ 14, 41 },
				{ 15, 41 },
				{ 16, 41 },
				{ 17, 41 },
				{ 19, 41 },
				{ 21, 41 },
				{ 23, 41 },
				{ 24, 41 },
				{ 25, 41 },
				{ 26, 41 },
				{ 27, 41 },
				{ 28, 41 },
				{ 29, 41 },
				{ 31, 41 },
				{ 33, 41 },
				{ 35, 41 },
				{ 37, 41 },
				{ 39, 41 },
				{ 40, 41 },
				{ 41, 41 },
				{ 43, 41 },
				{ 45, 41 },
				{ 47, 41 },
				{ 49, 41 },
				{ 50, 41 },
				{ 51, 41 },
				{ 53, 41 },
				{ 54, 41 },
				{ 55, 41 },
				{ 56, 41 },
				{ 57, 41 },
				{ 58, 41 },
				{ 59, 41 },
				{ 61, 41 },
				{ 1, 42 },
				{ 5, 42 },
				{ 9, 42 },
				{ 17, 42 },
				{ 21, 42 },
				{ 25, 42 },
				{ 31, 42 },
				{ 33, 42 },
				{ 35, 42 },
				{ 41, 42 },
				{ 43, 42 },
				{ 45, 42 },
				{ 47, 42 },
				{ 51, 42 },
				{ 55, 42 },
				{ 59, 42 },
				{ 61, 42 },
				{ 1, 43 },
				{ 3, 43 },
				{ 4, 43 },
				{ 5, 43 },
				{ 7, 43 },
				{ 8, 43 },
				{ 9, 43 },
				{ 10, 43 },
				{ 11, 43 },
				{ 13, 43 },
				{ 15, 43 },
				{ 17, 43 },
				{ 18, 43 },
				{ 19, 43 },
				{ 20, 43 },
				{ 21, 43 },
				{ 22, 43 },
				{ 23, 43 },
				{ 25, 43 },
				{ 27, 43 },
				{ 28, 43 },
				{ 29, 43 },
				{ 30, 43 },
				{ 31, 43 },
				{ 33, 43 },
				{ 35, 43 },
				{ 36, 43 },
				{ 37, 43 },
				{ 38, 43 },
				{ 39, 43 },
				{ 41, 43 },
				{ 43, 43 },
				{ 45, 43 },
				{ 47, 43 },
				{ 48, 43 },
				{ 49, 43 },
				{ 51, 43 },
				{ 52, 43 },
				{ 53, 43 },
				{ 55, 43 },
				{ 57, 43 },
				{ 59, 43 },
				{ 61, 43 },
				{ 1, 44 },
				{ 3, 44 },
				{ 7, 44 },
				{ 13, 44 },
				{ 15, 44 },
				{ 19, 44 },
				{ 23, 44 },
				{ 25, 44 },
				{ 31, 44 },
				{ 33, 44 },
				{ 39, 44 },
				{ 41, 44 },
				{ 43, 44 },
				{ 45, 44 },
				{ 49, 44 },
				{ 53, 44 },
				{ 57, 44 },
				{ 61, 44 },
				{ 1, 45 },
				{ 3, 45 },
				{ 5, 45 },
				{ 6, 45 },
				{ 7, 45 },
				{ 9, 45 },
				{ 10, 45 },
				{ 11, 45 },
				{ 12, 45 },
				{ 13, 45 },
				{ 15, 45 },
				{ 16, 45 },
				{ 17, 45 },
				{ 18, 45 },
				{ 19, 45 },
				{ 21, 45 },
				{ 23, 45 },
				{ 25, 45 },
				{ 27, 45 },
				{ 28, 45 },
				{ 29, 45 },
				{ 31, 45 },
				{ 33, 45 },
				{ 34, 45 },
				{ 35, 45 },
				{ 36, 45 },
				{ 37, 45 },
				{ 39, 45 },
				{ 40, 45 },
				{ 41, 45 },
				{ 43, 45 },
				{ 44, 45 },
				{ 45, 45 },
				{ 46, 45 },
				{ 47, 45 },
				{ 49, 45 },
				{ 51, 45 },
				{ 52, 45 },
				{ 53, 45 },
				{ 54, 45 },
				{ 55, 45 },
				{ 56, 45 },
				{ 57, 45 },
				{ 58, 45 },
				{ 59, 45 },
				{ 61, 45 },
				{ 1, 46 },
				{ 5, 46 },
				{ 13, 46 },
				{ 17, 46 },
				{ 21, 46 },
				{ 25, 46 },
				{ 27, 46 },
				{ 31, 46 },
				{ 33, 46 },
				{ 39, 46 },
				{ 43, 46 },
				{ 49, 46 },
				{ 59, 46 },
				{ 61, 46 },
				{ 1, 47 },
				{ 2, 47 },
				{ 3, 47 },
				{ 4, 47 },
				{ 5, 47 },
				{ 7, 47 },
				{ 8, 47 },
				{ 9, 47 },
				{ 10, 47 },
				{ 11, 47 },
				{ 13, 47 },
				{ 14, 47 },
				{ 15, 47 },
				{ 17, 47 },
				{ 19, 47 },
				{ 20, 47 },
				{ 21, 47 },
				{ 22, 47 },
				{ 23, 47 },
				{ 24, 47 },
				{ 25, 47 },
				{ 26, 47 },
				{ 27, 47 },
				{ 29, 47 },
				{ 30, 47 },
				{ 31, 47 },
				{ 32, 47 },
				{ 33, 47 },
				{ 35, 47 },
				{ 36, 47 },
				{ 37, 47 },
				{ 38, 47 },
				{ 39, 47 },
				{ 41, 47 },
				{ 42, 47 },
				{ 43, 47 },
				{ 45, 47 },
				{ 46, 47 },
				{ 47, 47 },
				{ 49, 47 },
				{ 50, 47 },
				{ 51, 47 },
				{ 52, 47 },
				{ 53, 47 },
				{ 54, 47 },
				{ 55, 47 },
				{ 57, 47 },
				{ 59, 47 },
				{ 61, 47 },
				{ 1, 48 },
				{ 5, 48 },
				{ 7, 48 },
				{ 11, 48 },
				{ 15, 48 },
				{ 17, 48 },
				{ 27, 48 },
				{ 33, 48 },
				{ 41, 48 },
				{ 45, 48 },
				{ 49, 48 },
				{ 55, 48 },
				{ 57, 48 },
				{ 59, 48 },
				{ 61, 48 },
				{ 1, 49 },
				{ 3, 49 },
				{ 4, 49 },
				{ 5, 49 },
				{ 7, 49 },
				{ 9, 49 },
				{ 10, 49 },
				{ 11, 49 },
				{ 12, 49 },
				{ 13, 49 },
				{ 15, 49 },
				{ 16, 49 },
				{ 17, 49 },
				{ 18, 49 },
				{ 19, 49 },
				{ 20, 49 },
				{ 21, 49 },
				{ 22, 49 },
				{ 23, 49 },
				{ 24, 49 },
				{ 25, 49 },
				{ 27, 49 },
				{ 28, 49 },
				{ 29, 49 },
				{ 30, 49 },
				{ 31, 49 },
				{ 33, 49 },
				{ 34, 49 },
				{ 35, 49 },
				{ 37, 49 },
				{ 38, 49 },
				{ 39, 49 },
				{ 40, 49 },
				{ 41, 49 },
				{ 43, 49 },
				{ 44, 49 },
				{ 45, 49 },
				{ 46, 49 },
				{ 47, 49 },
				{ 49, 49 },
				{ 51, 49 },
				{ 52, 49 },
				{ 53, 49 },
				{ 55, 49 },
				{ 57, 49 },
				{ 59, 49 },
				{ 61, 49 },
				{ 1, 50 },
				{ 9, 50 },
				{ 13, 50 },
				{ 25, 50 },
				{ 31, 50 },
				{ 35, 50 },
				{ 39, 50 },
				{ 47, 50 },
				{ 49, 50 },
				{ 51, 50 },
				{ 55, 50 },
				{ 57, 50 },
				{ 59, 50 },
				{ 61, 50 },
				{ 1, 51 },
				{ 2, 51 },
				{ 3, 51 },
				{ 4, 51 },
				{ 5, 51 },
				{ 6, 51 },
				{ 7, 51 },
				{ 8, 51 },
				{ 9, 51 },
				{ 11, 51 },
				{ 13, 51 },
				{ 15, 51 },
				{ 16, 51 },
				{ 17, 51 },
				{ 19, 51 },
				{ 20, 51 },
				{ 21, 51 },
				{ 22, 51 },
				{ 23, 51 },
				{ 24, 51 },
				{ 25, 51 },
				{ 26, 51 },
				{ 27, 51 },
				{ 28, 51 },
				{ 29, 51 },
				{ 31, 51 },
				{ 32, 51 },
				{ 33, 51 },
				{ 35, 51 },
				{ 36, 51 },
				{ 37, 51 },
				{ 39, 51 },
				{ 40, 51 },
				{ 41, 51 },
				{ 42, 51 },
				{ 43, 51 },
				{ 44, 51 },
				{ 45, 51 },
				{ 47, 51 },
				{ 49, 51 },
				{ 51, 51 },
				{ 52, 51 },
				{ 53, 51 },
				{ 55, 51 },
				{ 57, 51 },
				{ 59, 51 },
				{ 61, 51 },
				{ 1, 52 },
				{ 11, 52 },
				{ 13, 52 },
				{ 15, 52 },
				{ 19, 52 },
				{ 29, 52 },
				{ 31, 52 },
				{ 35, 52 },
				{ 37, 52 },
				{ 45, 52 },
				{ 47, 52 },
				{ 49, 52 },
				{ 53, 52 },
				{ 57, 52 },
				{ 59, 52 },
				{ 61, 52 },
				{ 1, 53 },
				{ 3, 53 },
				{ 4, 53 },
				{ 5, 53 },
				{ 6, 53 },
				{ 7, 53 },
				{ 8, 53 },
				{ 9, 53 },
				{ 10, 53 },
				{ 11, 53 },
				{ 13, 53 },
				{ 14, 53 },
				{ 15, 53 },
				{ 17, 53 },
				{ 18, 53 },
				{ 19, 53 },
				{ 21, 53 },
				{ 22, 53 },
				{ 23, 53 },
				{ 24, 53 },
				{ 25, 53 },
				{ 27, 53 },
				{ 29, 53 },
				{ 31, 53 },
				{ 33, 53 },
				{ 35, 53 },
				{ 37, 53 },
				{ 38, 53 },
				{ 39, 53 },
				{ 40, 53 },
				{ 41, 53 },
				{ 42, 53 },
				{ 43, 53 },
				{ 45, 53 },
				{ 47, 53 },
				{ 49, 53 },
				{ 50, 53 },
				{ 51, 53 },
				{ 53, 53 },
				{ 54, 53 },
				{ 55, 53 },
				{ 56, 53 },
				{ 57, 53 },
				{ 58, 53 },
				{ 59, 53 },
				{ 61, 53 },
				{ 1, 54 },
				{ 7, 54 },
				{ 17, 54 },
				{ 21, 54 },
				{ 27, 54 },
				{ 29, 54 },
				{ 31, 54 },
				{ 33, 54 },
				{ 35, 54 },
				{ 37, 54 },
				{ 43, 54 },
				{ 47, 54 },
				{ 49, 54 },
				{ 51, 54 },
				{ 57, 54 },
				{ 61, 54 },
				{ 1, 55 },
				{ 3, 55 },
				{ 4, 55 },
				{ 5, 55 },
				{ 7, 55 },
				{ 9, 55 },
				{ 11, 55 },
				{ 12, 55 },
				{ 13, 55 },
				{ 15, 55 },
				{ 16, 55 },
				{ 17, 55 },
				{ 19, 55 },
				{ 20, 55 },
				{ 21, 55 },
				{ 23, 55 },
				{ 24, 55 },
				{ 25, 55 },
				{ 26, 55 },
				{ 27, 55 },
				{ 28, 55 },
				{ 29, 55 },
				{ 31, 55 },
				{ 32, 55 },
				{ 33, 55 },
				{ 35, 55 },
				{ 37, 55 },
				{ 39, 55 },
				{ 40, 55 },
				{ 41, 55 },
				{ 43, 55 },
				{ 44, 55 },
				{ 45, 55 },
				{ 46, 55 },
				{ 47, 55 },
				{ 49, 55 },
				{ 51, 55 },
				{ 52, 55 },
				{ 53, 55 },
				{ 54, 55 },
				{ 55, 55 },
				{ 57, 55 },
				{ 59, 55 },
				{ 60, 55 },
				{ 61, 55 },
				{ 1, 56 },
				{ 3, 56 },
				{ 5, 56 },
				{ 7, 56 },
				{ 9, 56 },
				{ 13, 56 },
				{ 15, 56 },
				{ 19, 56 },
				{ 21, 56 },
				{ 29, 56 },
				{ 35, 56 },
				{ 37, 56 },
				{ 41, 56 },
				{ 47, 56 },
				{ 49, 56 },
				{ 55, 56 },
				{ 59, 56 },
				{ 61, 56 },
				{ 1, 57 },
				{ 3, 57 },
				{ 5, 57 },
				{ 7, 57 },
				{ 9, 57 },
				{ 10, 57 },
				{ 11, 57 },
				{ 12, 57 },
				{ 13, 57 },
				{ 15, 57 },
				{ 17, 57 },
				{ 18, 57 },
				{ 19, 57 },
				{ 21, 57 },
				{ 22, 57 },
				{ 23, 57 },
				{ 24, 57 },
				{ 25, 57 },
				{ 26, 57 },
				{ 27, 57 },
				{ 29, 57 },
				{ 30, 57 },
				{ 31, 57 },
				{ 32, 57 },
				{ 33, 57 },
				{ 34, 57 },
				{ 35, 57 },
				{ 37, 57 },
				{ 38, 57 },
				{ 39, 57 },
				{ 41, 57 },
				{ 42, 57 },
				{ 43, 57 },
				{ 45, 57 },
				{ 46, 57 },
				{ 47, 57 },
				{ 49, 57 },
				{ 50, 57 },
				{ 51, 57 },
				{ 53, 57 },
				{ 55, 57 },
				{ 56, 57 },
				{ 57, 57 },
				{ 58, 57 },
				{ 59, 57 },
				{ 61, 57 },
				{ 1, 58 },
				{ 3, 58 },
				{ 5, 58 },
				{ 7, 58 },
				{ 9, 58 },
				{ 13, 58 },
				{ 15, 58 },
				{ 17, 58 },
				{ 25, 58 },
				{ 27, 58 },
				{ 39, 58 },
				{ 43, 58 },
				{ 45, 58 },
				{ 49, 58 },
				{ 53, 58 },
				{ 57, 58 },
				{ 61, 58 },
				{ 1, 59 },
				{ 3, 59 },
				{ 5, 59 },
				{ 7, 59 },
				{ 8, 59 },
				{ 9, 59 },
				{ 11, 59 },
				{ 13, 59 },
				{ 14, 59 },
				{ 15, 59 },
				{ 17, 59 },
				{ 18, 59 },
				{ 19, 59 },
				{ 20, 59 },
				{ 21, 59 },
				{ 23, 59 },
				{ 25, 59 },
				{ 27, 59 },
				{ 29, 59 },
				{ 30, 59 },
				{ 31, 59 },
				{ 32, 59 },
				{ 33, 59 },
				{ 34, 59 },
				{ 35, 59 },
				{ 36, 59 },
				{ 37, 59 },
				{ 38, 59 },
				{ 39, 59 },
				{ 40, 59 },
				{ 41, 59 },
				{ 43, 59 },
				{ 45, 59 },
				{ 47, 59 },
				{ 48, 59 },
				{ 49, 59 },
				{ 50, 59 },
				{ 51, 59 },
				{ 53, 59 },
				{ 54, 59 },
				{ 55, 59 },
				{ 57, 59 },
				{ 59, 59 },
				{ 60, 59 },
				{ 61, 59 },
				{ 1, 60 },
				{ 5, 60 },
				{ 11, 60 },
				{ 23, 60 },
				{ 27, 60 },
				{ 43, 60 },
				{ 53, 60 },
				{ 61, 60 },
				{ 1, 61 },
				{ 2, 61 },
				{ 3, 61 },
				{ 4, 61 },
				{ 5, 61 },
				{ 6, 61 },
				{ 7, 61 },
				{ 8, 61 },
				{ 9, 61 },
				{ 10, 61 },
				{ 11, 61 },
				{ 12, 61 },
				{ 13, 61 },
				{ 14, 61 },
				{ 15, 61 },
				{ 16, 61 },
				{ 17, 61 },
				{ 18, 61 },
				{ 19, 61 },
				{ 20, 61 },
				{ 21, 61 },
				{ 22, 61 },
				{ 23, 61 },
				{ 24, 61 },
				{ 25, 61 },
				{ 26, 61 },
				{ 27, 61 },
				{ 28, 61 },
				{ 29, 61 },
				{ 30, 61 },
				{ 31, 61 },
				{ 32, 61 },
				{ 33, 61 },
				{ 34, 61 },
				{ 35, 61 },
				{ 36, 61 },
				{ 37, 61 },
				{ 38, 61 },
				{ 39, 61 },
				{ 40, 61 },
				{ 41, 61 },
				{ 42, 61 },
				{ 43, 61 },
				{ 44, 61 },
				{ 45, 61 },
				{ 46, 61 },
				{ 47, 61 },
				{ 48, 61 },
				{ 49, 61 },
				{ 50, 61 },
				{ 51, 61 },
				{ 52, 61 },
				{ 53, 61 },
				{ 54, 61 },
				{ 55, 61 },
				{ 56, 61 },
				{ 57, 61 },
				{ 58, 61 },
				{ 59, 61 },
				{ 60, 61 },
				{ 61, 61 } };
		int obs[][] = new int[2][obs_error.length];
		for (int i = 0; i < obs_error.length; i++) {
			obs[0][i] = obs_error[i][0] - 1;
			obs[1][i] = obs_error[i][1] - 1;
		}
		// int obs[][] =
		// {{2,2,2,2,2,2,2,2,2,4,4,4,4,4,4,4,4,4},{0,1,2,3,4,5,6,7,8,9,8,7,6,5,4,3,2,1}};
		int en_des[][] = { { 1, 59 }, { 1, 59 } };
		int x1;
		int x2;
		// for (int i =0; i< 3000;)
		// {
		// x1 = (int)(Math.random()*100);
		// x2 = (int)(Math.random()*100);
		//// System.out.println("x1:"+x1);
		//// System.out.println("x2:"+x2);
		// if(((x1==en_des[0][0])&&(x2==en_des[1][0]))||((x1==en_des[0][1])&&(x2==en_des[1][1])))
		// {
		// continue;
		// }
		// obs[0][i] = x1;
		// obs[1][i] = x2;
		// i++;
		// }

		int a1 = 61;
		int b1 = 61;
		Graph a = new Graph(a1, b1, obs, en_des);
		// LinkedList<Node> trace = new LinkedList<>();
		ArrayList<LinkedList<Node>> array = new ArrayList<LinkedList<Node>>();
		Astar sObj = new Astar();
		array = sObj.Astar_Chebyshev(a);
		// array = sObj. Astar_Manhattan(a);
		System.out.println(array.get(0).size());
		int trace_location[][] = new int[2][array.get(0).size()];
		for (int i = 0; i < array.get(0).size(); i++) {

			trace_location[0][i] = array.get(0).get(i).x;
			trace_location[1][i] = array.get(0).get(i).y;
			System.out.println("x:" + array.get(0).get(i).x + "y:" + array.get(0).get(i).y);
		}

		Draw frame = new Draw(en_des, obs, trace_location, a1, b1, array);
		frame.setVisible(true);

		// System.out.println(a.members[1][2].equals(a.members[1][1]));
		// Node members[][]= new Node[10][10];
		// Node Nodes[] = new Node[10];
		// LinkedList<Node> list = new LinkedList<>();
		// extend(list);
		// System.out.println(list.get(0).x);
		// Node a = new Node(1,1);
		// Node b = new Node(1,2);
		// Node c = new Node(1,3);
		// Node d = new Node(1,4);
		// Node e = new Node(1,5);
		// Node f = new Node(1,6);
		// f.Father =e;
		// e.Father =d;
		// d.Father =c;
		// c.Father =b;
		// b.Father =a;
		// System.out.println(findRealGx(f));
		// Random random = new Random();
		// for(int i =0 ;i< 10;i++)
		// {
		// Nodes[i] = new Node(i,i);
		// Nodes[i].fx = (int)(Math.random()*100);
		// Nodes[i].hx = (int)(Math.random()*100);
		// System.out.println("fx: " +Nodes[i].fx+" hx:" +Nodes[i].hx);
		// list.add(Nodes[i]);
		// }

	}
}
