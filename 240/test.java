
public class test {

	public static void main(String[] args) {
		
	}
//		int[][] matrix = {
//				{1,  2,  3,  4,  5},
//				{6,  7,  8,  9,  10},
//				{11, 12, 13, 14, 15},
//				{16, 17, 18, 19, 20},
//				{21, 22, 23, 24, 25}
//		};
//		int size = matrix.length - 1;
//        int num_layers = 0;
//        num_layers = size/2;
//        if(size%2 == 1) {
//                num_layers++;
//        }
//
//        int i;
//        for(i = 0; i < num_layers; i++) {
//                int row_num, col_num;
//                int k, j;
//
//                //corner case: size is odd & the layer is last so only one entry to print
//                if(size % 2 == 1 && i == (size + 1) / 2 - 1){
//                        System.out.print(matrix[i][i] + " ");
//                        return;
//                }
//
//                //Traverse upper row from left to right with appropriate bounds
//                row_num = i;
//                for(k = row_num; k <= size - row_num; k++) {
//                		System.out.print(matrix[row_num][k] + " ");
//                }
//
//                //Traverse right column from top to bottom with appropriate bounds
//                col_num = size - i;
//                for(k = i + 1; k <= col_num; k++) {
//                		System.out.print(matrix[k][col_num] + " ");
//                }
//
//                //Traverse lower row from right to left with appropriate bounds
//                row_num = size - i;
//                if(i + 1 <= row_num){
//                for(k = row_num - 1; k >= i; k--) {
//                		System.out.print(matrix[row_num][k] + " ");
//                }
//                }
//
//                //Traverse left column from bottom to top with appropriate bounds
//                col_num = i;
//                if(col_num + 1 <= size - i){
//                for(k = size - col_num - 1; k > col_num; k--) {
//                		System.out.print(matrix[k][col_num] + " ");
//                }
//                }
//        }
//        
//		int[] array = {3, 5, 7, 4, 10};
//        int elem = 5;
//        int temp = 0;
//        
//        for (int i = 0; i < elem; i++) {
//        		for (int j = i; j < elem; j++) {
//        			while (array[i] < array[j]) {
//        				temp = array[i];
//        				array[i] = array[j];
//        				array[j] = temp;
//        			}
//        		}
//        }
//        for (int i = 0; i < elem; i++) {
//        		System.out.println(array[i]);
//        }
//	}
//
//		int row_num = 0;
//		int col_num = 0;
//		int size = matrix.length - 1;
//		   
//		while(row_num <= size && col_num <= size){
//		   
//			for (int i = row_num; i <= size; i++) {
//				System.out.print(matrix[row_num][i] + " ");
//			}
//		 
//			for (int j = row_num + 1; j <= size; j++) {
//				System.out.print(matrix[j][size] + " ");
//			}
//		    
//			if(row_num + 1 <= size){
//				for (int k = size - 1; k >= col_num; k--) {
//		    			System.out.print(matrix[size][k] + " ");
//				}
//			}
//			if(col_num + 1 <= size){
//				for (int k = size - 1; k > row_num; k--) {
//					System.out.print(matrix[k][col_num] + " ");
//				}
//			}
//			row_num++;
//			size--;
//			col_num++;
//		 	}
	
}
