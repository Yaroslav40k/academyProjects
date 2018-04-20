/*** 
 * Custom made, auto-increase array, 
 * to hold Integer values
 * can hold max of two copies of each Integer.
 *
 */

package com.andersen.collections;

import java.util.Arrays;
import java.util.TreeSet;

public class CustomArrayList  <E extends Integer>{

	private static final int DEFAULT_CAPACITY = 5;
	private Object[] primarisArray;
	private int objInArrayCount = 0;

	public CustomArrayList()  {
		this.primarisArray = new Object[DEFAULT_CAPACITY];
	}

	public CustomArrayList(int length) {
		this.primarisArray =  new Object[length];
	}

	private void ensureCapacity() {
		if (this.objInArrayCount == (primarisArray.length - 1)) {
			this.enlargeArray();
		}
	}

	private void enlargeArray() {
		Object[] elementsTMP =  new Object[this.primarisArray.length * 2];
		for (int i = 0; i < this.primarisArray.length; i++) {
			elementsTMP[i] = this.primarisArray[i];
		}
		this.primarisArray = elementsTMP;
	}

	private void enlargeArray(int additionalLength) {
		Object[] elementsTMP = new Object[this.primarisArray.length + additionalLength];
		for (int i = 0; i < this.primarisArray.length; i++) {
			elementsTMP[i] = this.primarisArray[i];
		}
		this.primarisArray = elementsTMP;
	}

	public boolean add(E elem) {
		this.ensureCapacity();
		if (isEnoughCopies(elem)) {
			this.primarisArray[this.objInArrayCount++] = elem;
			return true;
		} else {
			return false;
		}
	}

	private boolean isEnoughCopies(E elem) {
		int copiesCount = 0;
		for (int i = 0; i < primarisArray.length; i++) {
			if (elem.equals(primarisArray[i])) {
				copiesCount++;
				if (copiesCount == 2) {
					return false;
				}
			}
		}
		return true;
	}

	public E getByIndex(int index) {
		rangeCheck(index);
		return (E) this.primarisArray[index];
	}

	public E getByValue(E elem) throws NullPointerException {
		trimArray();
		E requestedElem = null;
		Object[] array =  this.primarisArray;		
		Arrays.sort(array);
		int low = 0;
		int high = array.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			E guess = (E) array[mid];
			if (guess.compareTo(elem) == 0) {
				requestedElem = guess;
				return requestedElem;
			}
			if (guess.compareTo(elem) == -1) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return requestedElem;
	}

	public boolean setByValue(E elem) {
		for (int i = 0; i < primarisArray.length; i++) {
			if (elem.equals(primarisArray[i])) {
				primarisArray[i] = elem;
				return true;
			}
		}
		return false;
	}

	public boolean delete(E elem) {
		for (int i = 0; i < primarisArray.length; i++) {
			if (elem.equals(primarisArray[i])) {
				primarisArray[i] = null;
				Object[] trimedPartOne = new Object[i];
				Object[] trimedPartTwo = new Object[primarisArray.length - (i + 1)];
				System.arraycopy(this.primarisArray, i + 1, this.primarisArray, i, this.primarisArray.length - i - 2);
				this.objInArrayCount--;
				return true;
			}
		}
		return false;
	}

	public E findMax() {
		E max = (E) primarisArray[0];
		for (int i = 1; i < primarisArray.length; i++) {
			if (primarisArray[i] != null) {
				if (((E)(primarisArray[i])).compareTo(max) == 1 ){
					max = (E) primarisArray[i];
				}
			} else {
				break;
			}
		}
		return max;
	}

	public E findMin() {
		E min = (E) primarisArray[0];
		for (int i = 1; i < primarisArray.length; i++) {
			if (primarisArray[i] != null) {
				if (((E)(primarisArray[i])).compareTo(min) == -1 ){
					min = (E) primarisArray[i];
				}
			}  else {
				break;
			}
		}
		return min;
	}

	public Integer findAvgOfAll() {
		Integer sumOfAllElems = (Integer) primarisArray[0];
		for (int i = 1; i < primarisArray.length; i++) {
			if (primarisArray[i] == null) {
				break;
			}
			sumOfAllElems += ((Integer)primarisArray[i]).intValue();
		}
		int avg = sumOfAllElems / objInArrayCount;
		return avg;
	}

	public void mergeCustomArrays(CustomArrayList<E> customList) {
		Object[] secondArray = customList.primarisArray;
		int secondArrayLength = secondArray.length;
		enlargeArray(secondArrayLength);
		System.arraycopy(secondArray, 0, this.primarisArray, this.objInArrayCount, secondArrayLength);
		objInArrayCount += customList.length();
	}

	public Object[] toArray() {
		return primarisArray;

	}

	private void rangeCheck(int index) {
		if (index > this.objInArrayCount) {
			throw new IndexOutOfBoundsException("I feel disturbance in the Array! We can`t reach index " + index);
		}
	}

	public void trimArray() {
		Object[] trimmedArray = new Object[objInArrayCount];
		System.arraycopy(this.primarisArray, 0, trimmedArray, 0, objInArrayCount);
		this.primarisArray = trimmedArray;
	}

	public void printCustomList() {
		for (int i = 0; i < primarisArray.length; i++) {
			if (primarisArray[i] == null) {
				break;
			}
			System.out.print(primarisArray[i] + ",");
		}
		System.out.println();
	}

	public int length() {
		return objInArrayCount;
	}

}
