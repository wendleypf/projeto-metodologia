package com.metodologia.model;

public class MergeSortImpl {

	public void sort(String[] array) {
		sort(array, 0, array.length-1);
	}

	private void sort(String[] array, int left, int right){
		if (left < right){
			int middle = left + (right - left)/2;

			sort(array, left, middle);
			sort(array, middle+1, right);
			merge(array, left, middle, right);
		}
	}

	public void merge(String[] array, int left, int middle, int right) {
		String[] arrayAux = new String[array.length];

		for (int i = left; i <= right; i++) {
			arrayAux[i] = array[i];
		}

		int left1 = left;
		int middleAux = middle + 1;
		int left2 = left;

		while (left1 <= middle && middleAux <= right) {
			if (arrayAux[left1].compareTo(arrayAux[middleAux])<=0) {
				array[left2] = arrayAux[left1];
				left1++;
			} else {
				array[left2] = arrayAux[middleAux];
				middleAux++;
			}
			left2++;
		}

		while (left1 <= middle) {
			array[left2] = arrayAux[left1];
			left2++;
			left1++;
		}
	}
}
