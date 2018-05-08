import java.util.ArrayList;
public class Method01 {
	private Integer[] HashTable;

	private ArrayList<Integer []>hashFunctions;

	private int size;

	public ArrayList<Integer> valuesInserted = new ArrayList<Integer>();

	public Method01(ArrayList<Integer []> arr,int b){
		hashFunctions = arr;
		size = (int) Math.pow(2 , b );
	}



	public void insert(int[] arr) {



		this.HashTable = new Integer[size];

		int key = 0;

		Integer[] hashFunction = hashFunctions.get(0);
		Integer[] temp = new Integer[hashFunction.length];



		for(int i=0;i<arr.length;i++){
			boolean flag = true;

			hashFunction = hashFunctions.get(0) ;

			for(int j=0;j<hashFunction.length;j++){
				temp[j] = arr[i] ^ hashFunction[j];
			}
			key = hashing(temp);

			if(HashTable[key] == null){
				HashTable[key] = arr[i];
				valuesInserted.add(arr[i]);
			}

			else{
				int x = 1;
				while(flag){
					hashFunction = hashFunctions.get(x);
					for(int j=0;j<hashFunction.length;j++){
						temp[j] = arr[i] ^ hashFunction[j];
					}
					key = hashing(temp);

					if(HashTable[key] == null){
						HashTable[key] = arr[i];
						valuesInserted.add(arr[i]);
						flag = false;

					}
					else {
						x++;
					}
				}

			}
		}

	}

	public boolean find(int value){

		int key = 0;

		boolean flag = true;

		Integer[] hashFunction = hashFunctions.get(0);
		Integer[] temp = new Integer[hashFunction.length];

		for(int j=0;j<hashFunction.length;j++){
			temp[j] = value ^ hashFunction[j];
		}
		key = hashing(temp);
		if(HashTable[key] == null){
			return false;
		}
		else if(HashTable[key] == value){
			return true;
		}
		else{
			int x = 1;
			while(flag){
				hashFunction = hashFunctions.get(x);
				for(int j=0;j<hashFunction.length;j++){
					temp[j] = value ^ hashFunction[j];
				}
				key = hashing(temp);
				if(HashTable[key] == null){

					//flag = false;
					return false;
				}
				else if(HashTable[key] == value){
					//flag = false;
					return true;
				}
				else {
					x++;
				}
			}
		}
		return false;
	}

	private int hashing(Integer[] arr) {

		int value = 0;
		Integer[] binaryValue = new Integer[arr.length];
		for(int i=0;i<arr.length;i++){
			int counter = 0;
			String s = Integer.toBinaryString(arr[i]);
			for(int j=0;j<s.length();j++){
				if(s.charAt(j) == '1'){
					counter++;
				}
			}
			binaryValue[i] = Math.floorMod(counter, 2);
		}

		for(int i=0;i<binaryValue.length;i++){
			value += binaryValue[i] * (int) Math.pow(2.0, (double)i);
		}
		return value;
	}
}