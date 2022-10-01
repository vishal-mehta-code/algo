package array;

public class SubSetCount {

	public static void main(String[] args) {
		System.out.println(findSubsets(4, 3));
	}

	private static int findSubsets(int noOfElements, int noOfElementsInAGroup) {
		if (noOfElementsInAGroup == 0 || noOfElements == noOfElementsInAGroup)
			return 1;

		return findSubsets(noOfElements - 1, noOfElementsInAGroup - 1) + findSubsets(noOfElements - 1, noOfElementsInAGroup);
	}
}
