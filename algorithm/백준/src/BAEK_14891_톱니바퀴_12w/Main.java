package BAEK_14891_톱니바퀴_12w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int value, location;

		public Node(int value, int location) {
			super();
			this.value = value;
			this.location = location;
		}
		
		
	}
	static Node[] arr1 = new Node[8];
	static Node[] arr2 = new Node[8];
	static Node[] arr3 = new Node[8];
	static Node[] arr4 = new Node[8];
	static boolean oneTwo, twoThree, threeFour;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//0번 12시 2번 3시 4번 6시 6번 9시
		//N극 0 S극 1
		//시계방향 1 반시계 -1
		
	    arr1 = new Node[8];
	    char[] a1 = new char[8];
		arr2 = new Node[8];
		char[] a2 = new char[8];
		arr3 = new Node[8];
		char[] a3 = new char[8];
		arr4 = new Node[8];
		char[] a4 = new char[8];
		
		for(int i = 0; i<4; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			if(i == 0) {
				a1 = str.toCharArray();
			}else if(i == 1) {
				a2 = str.toCharArray();
			}else if(i == 2) {
				a3 = str.toCharArray();
			}else {
				a4 = str.toCharArray();
			}
			
		}
		
		for(int i = 0; i<8; i++) {
			int num = Integer.parseInt(a1[i]+"");
			arr1[i] = new Node(num, i);
			int num2 = Integer.parseInt(a2[i]+"");
			arr2[i] = new Node(num2, i);
			int num3 = Integer.parseInt(a3[i]+"");
			arr3[i] = new Node(num3, i);
			int num4 = Integer.parseInt(a4[i]+"");
			arr4[i] = new Node(num4, i);
		}
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<N; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			while(st.hasMoreTokens()) {
				int location = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken());
				
				move(location, direction);
			}
		}
		System.out.println();
	}

	private static void move(int location, int direction) {
		if(arr1[2].value == arr2[6].value) {
			oneTwo = true;
		}else {
			oneTwo = false;
		}
		if(arr2[2].value == arr3[6].value) {
			twoThree = true;
		}else {
			twoThree = false;
		}
		if(arr3[2].value == arr4[6].value) {
			threeFour = true;
		}else {
			threeFour = false;
		}
		
		if(location == 1) {
			if(direction == 1) {
				for(int i = 0; i<8; i++) {
					if(arr1[i].location == 7) {
						arr1[i].location = 0;
					}else {
						arr1[i].location++;
					}
				}
			}else {
				for(int i = 0; i<8; i++) {
					if(arr1[i].location == 0) {
						arr1[i].location = 7;
					}else {
						arr1[i].location--;
					}
				}
			}
			if(oneTwo) {
			}else {
				if(-direction == 1) {
					for(int i = 0; i<8; i++) {
						if(arr2[i].location == 7) {
							arr2[i].location = 0;
						}else {
							arr2[i].location++;
						}
					}
				}else {
					for(int i = 0; i<8; i++) {
						if(arr2[i].location == 0) {
							arr2[i].location = 7;
						}else {
							arr2[i].location--;
						}
					}
				}
				if(twoThree) {
					
				}else {
					if(direction == 1) {
						for(int i = 0; i<8; i++) {
							if(arr3[i].location == 7) {
								arr3[i].location = 0;
							}else {
								arr3[i].location++;
							}
						}
					}else {
						for(int i = 0; i<8; i++) {
							if(arr3[i].location == 0) {
								arr3[i].location = 7;
							}else {
								arr3[i].location--;
							}
						}
					}
					if(threeFour) {
						
					}else {
						if(-direction == 1) {
							for(int i = 0; i<8; i++) {
								if(arr4[i].location == 7) {
									arr4[i].location = 0;
								}else {
									arr4[i].location++;
								}
							}
						}else {
							for(int i = 0; i<8; i++) {
								if(arr4[i].location == 0) {
									arr4[i].location = 7;
								}else {
									arr4[i].location--;
								}
							}
						}
					}
				}
			}
		}else if(location == 2) {
			if(direction == 1) {
				for(int i = 0; i<8; i++) {
					if(arr2[i].location == 7) {
						arr2[i].location = 0;
					}else {
						arr2[i].location++;
					}
				}
			}else {
				for(int i = 0; i<8; i++) {
					if(arr2[i].location == 0) {
						arr2[i].location = 7;
					}else {
						arr2[i].location--;
					}
				}
			}
			if(oneTwo) {
				
			}else {
				if(-direction == 1) {
					for(int i = 0; i<8; i++) {
						if(arr1[i].location == 7) {
							arr1[i].location = 0;
						}else {
							arr1[i].location++;
						}
					}
				}else {
					for(int i = 0; i<8; i++) {
						if(arr1[i].location == 0) {
							arr1[i].location = 7;
						}else {
							arr1[i].location--;
						}
					}
				}
			}
			if(twoThree) {
				
			}else {
				if(-direction == 1) {
					for(int i = 0; i<8; i++) {
						if(arr3[i].location == 7) {
							arr3[i].location = 0;
						}else {
							arr3[i].location++;
						}
					}
				}else {
					for(int i = 0; i<8; i++) {
						if(arr3[i].location == 0) {
							arr3[i].location = 7;
						}else {
							arr3[i].location--;
						}
					}
				}
				if(threeFour) {
					
				}else {
					if(direction == 1) {
						for(int i = 0; i<8; i++) {
							if(arr4[i].location == 7) {
								arr4[i].location = 0;
							}else {
								arr4[i].location++;
							}
						}
					}else {
						for(int i = 0; i<8; i++) {
							if(arr4[i].location == 0) {
								arr4[i].location = 7;
							}else {
								arr4[i].location--;
							}
						}
					}
				}
			}
		}else if(location == 3) {
			if(direction == 1) {
				for(int i = 0; i<8; i++) {
					if(arr3[i].location == 7) {
						arr3[i].location = 0;
					}else {
						arr3[i].location++;
					}
				}
			}else {
				for(int i = 0; i<8; i++) {
					if(arr3[i].location == 0) {
						arr3[i].location = 7;
					}else {
						arr3[i].location--;
					}
				}
			}
			if(twoThree) {
				
			}else {
				if(-direction == 1) {
					for(int i = 0; i<8; i++) {
						if(arr2[i].location == 7) {
							arr2[i].location = 0;
						}else {
							arr2[i].location++;
						}
					}
				}else {
					for(int i = 0; i<8; i++) {
						if(arr2[i].location == 0) {
							arr2[i].location = 7;
						}else {
							arr2[i].location--;
						}
					}
				}
				if(oneTwo) {
					
				}else {
					if(direction == 1) {
						for(int i = 0; i<8; i++) {
							if(arr1[i].location == 7) {
								arr1[i].location = 0;
							}else {
								arr1[i].location++;
							}
						}
					}else {
						for(int i = 0; i<8; i++) {
							if(arr1[i].location == 0) {
								arr1[i].location = 7;
							}else {
								arr1[i].location--;
							}
						}
					}
				}
			}
			if(threeFour) {
				
			}else {
				if(-direction == 1) {
					for(int i = 0; i<8; i++) {
						if(arr4[i].location == 7) {
							arr4[i].location = 0;
						}else {
							arr4[i].location++;
						}
					}
				}else {
					for(int i = 0; i<8; i++) {
						if(arr4[i].location == 0) {
							arr4[i].location = 7;
						}else {
							arr4[i].location--;
						}
					}
				}
			}
		}else {
			if(direction == 1) {
				for(int i = 0; i<8; i++) {
					if(arr4[i].location == 7) {
						arr4[i].location = 0;
					}else {
						arr4[i].location++;
					}
				}
			}else {
				for(int i = 0; i<8; i++) {
					if(arr4[i].location == 0) {
						arr4[i].location = 7;
					}else {
						arr4[i].location--;
					}
				}
			}
			if(threeFour) {

			}else {
				if(-direction == 1) {
					for(int i = 0; i<8; i++) {
						if(arr3[i].location == 7) {
							arr3[i].location = 0;
						}else {
							arr3[i].location++;
						}
					}
				}else {
					for(int i = 0; i<8; i++) {
						if(arr3[i].location == 0) {
							arr3[i].location = 7;
						}else {
							arr3[i].location--;
						}
					}
				}
				if(twoThree) {
					
				}else {
					if(direction == 1) {
						for(int i = 0; i<8; i++) {
							if(arr2[i].location == 7) {
								arr2[i].location = 0;
							}else {
								arr2[i].location++;
							}
						}
					}else {
						for(int i = 0; i<8; i++) {
							if(arr2[i].location == 0) {
								arr2[i].location = 7;
							}else {
								arr2[i].location--;
							}
						}
					}
					if(oneTwo) {
						
					}else {
						if(-direction == 1) {
							for(int i = 0; i<8; i++) {
								if(arr1[i].location == 7) {
									arr1[i].location = 0;
								}else {
									arr1[i].location++;
								}
							}
						}else {
							for(int i = 0; i<8; i++) {
								if(arr1[i].location == 0) {
									arr1[i].location = 7;
								}else {
									arr1[i].location--;
								}
							}
						}
					}
				}
			}
		}
		
	}



}
