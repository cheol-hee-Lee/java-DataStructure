package MaxHeap;

import java.util.Arrays;

/**
 * 09. Heap
 * 
 * @author : 201802141, LeeCheolHee
 * 
 * 2019. 5. 8.
 * 
 */
public class MaxHeap {
	/**
	 * HeapArray
	 */
	private int[] Heap;
	/**
	 * 배열의 용량
	 */
	private int capacity;
	/**
	 * 저장된 원소의 개수
	 */
	private int size;

	/**
	 * 생성자
	 * 
	 * @param capacity 해당 용량을 가진 배열 생셩
	 */
	public MaxHeap(int capacity) {
		this.size = 0;
		this.capacity = capacity;
		Heap = new int[capacity];
	}

	/**
	 *  힙에 삽입, heapifyUp()을 통해 자식-부모로 오름차순 정렬
	 * 
	 * @param item 삽입할 원소
	 *
	 */
	public void insert(int item) {
		ensureExtraCapacity();
		Heap[size] = item;
		size++;
		heapifyUp();
	}

	/**
	 * Heap[0]에 있는 원소 삭제
	 * 1. Heap[0]과 Heap[size-1]을 swap
	 * 2. heapifyDown()을 통해 자식-부모로 오름차순 정렬
	 * 3. Heap[size-1] 반환
	 *	@return returnValue 반환된 값
	 */
	public int delete() {
		print();
		swap(0, size - 1);
		print();
		int returnValue = Heap[size - 1];
		Heap[size - 1] = 0;
		size--;
		print();
		heapifyDown();
		return returnValue;
	}

	public void print() {
		print(0, "", true);
	}

	/**
	 * 배열에서 부모-자식 관계를 확인하기 쉽게 Heap에 저장된 원소를 재귀적으로 출력
	 * 
	 * @param index 부모 인덱스
	 * @param prefix 트리 관계를 보여줄 때 사용되는 문자열
	 * @param isTail 자식이 없는지 여부
	 *
	 */
	private void print(int index, String prefix, boolean isTail) {
		if (index == 0) {
			System.out.println(prefix + "    " + Heap[index]);
		} else {
			System.out.println(prefix + (isTail ? "└── " : "├── ") + Heap[index]);
		}
		if (getChildSize(index) == 1) {
			print(2 * index + 1, prefix + (isTail ? "    " : "│   "), true);
		}

		if (getChildSize(index) == 2) {
			print(2 * index + 1, prefix + (isTail ? "    " : "│   "), false);
			print(2 * index + 2, prefix + (isTail ? "    " : "│   "), true);
		}
	}

	/**
	 *  insert하면 배열의 마지막, 즉 heap의 최하단에 원소가 삽입된다. 자식-부모로 오름차순 정렬되게 swap한다.
	 * 
	 *
	 */
	private void heapifyUp() {
		int index = size - 1;
		while (hasParent(index) && parent(index) < Heap[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}

	/**
	 * delete할 때 배열의 첫번쨰 원소가 마지막 원소와 swap되고 삭제된다. 
	 * 이 때 변경된 배열의 첫번쨰 원소를 자식-부모로 오름차순이 되도록 자식과 비교하며 swap한다. 
	 * 
	 */
	private void heapifyDown() {
		int index = 0;
		while (hasLeftChild(index)) {
			int biggerChildIndex = getLeftChildIndex(index);
			if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
				biggerChildIndex = getRightChildIndex(index);
			}

			if (Heap[index] > Heap[biggerChildIndex]) {
				break;
			} else {
				swap(index, biggerChildIndex);
				print();
			}
			index = biggerChildIndex;
		}

	}

	/**
	 * 부모 인덱스를 통해 자식의 수를 얻는다.
	 * 
	 * @param index 부모 인덱스
	 *
	 * @return childSize 자식의 수 
	 *
	 */
	public int getChildSize(int index) {
		int childSize = 0;
		if (Heap[2 * index + 1] != 0) {
			childSize++;
		}
		if (Heap[2 * index + 2] != 0) {
			childSize++;
		}
		return childSize;
	}

	/**
	 * HeapArray를 반환
	 * 
	 * @return Heap HeapArray
	 *
	 */
	public int[] getHeap() {
		return Heap;
	}

	/**
	 * size를 반환
	 * 
	 * @return size size
	 *
	 */
	public int size() {
		return size;
	}

	/**
	 * 배열의 용량을 반환
	 * 
	 * @return capacity 배열의 용량
	 *
	 */
	public int capacity() {
		return capacity;
	}

	/**
	 * 
	 * @param parentIndex 부모 인덱스
	 *
	 * @return childIndex 자식 인덱스
	 *
	 */
	private int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}

	/**
	 * 
	 * 
	 * @param parentIndex 부모 인덱스
	 *
	 * @return childIndex 자식 인덱스
	 *
	 */
	private int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}

	/**
	 * 
	 * 
	 * @param childIndex 자식 인덱스
	 *
	 * @return parentIndex 부모 인덱스
	 *
	 */
	private int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	/**
	 * 해당 인덱스의 왼쪽자식이 있는지 여부를 반환한다.
	 * 
	 * @param index 부모 인덱스
	 *
	 * @return hasLeftChild 왼쪽 자식이 있는지 여부
	 *
	 */
	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}
	/**
	 * 해당 인덱스의 오른쪽자식이 있는지 여부를 반환한다.
	 * 
	 * @param index 부모 인덱스
	 *
	 * @return hasRightChild 오른쪽 자식이 있는지 여부
	 *
	 */
	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}
	/**
	 * 해당 인덱스의 부모가 있는지 여부를 반환한다.
	 * 
	 * @param index 자식 인덱스
	 *
	 * @return hasParent 부모가 있는지 여부
	 *
	 */
	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	
	/**
	 * 왼쪽 자식 값을 반환
	 * 
	 * @param index 부모 인덱스
	 *
	 * @return leftChild 왼쪽 자식 값
	 *
	 */
	private int leftChild(int index) {
		return Heap[getLeftChildIndex(index)];
	}

	/**
	 * 오른쪽 자식 값을 반환
	 * 
	 * @param index 부모 인덱스
	 *
	 * @return rightChild 오른쪽 자식 값
	 *
	 */
	private int rightChild(int index) {
		return Heap[getRightChildIndex(index)];
	}

	/**
	 * 부모 값을 반환
	 * 
	 * @param index 자식 인덱스
	 *
	 * @return parent 부모 값
	 *
	 */
	private int parent(int index) {
		return Heap[getParentIndex(index)];
	}

	/**
	 * 배열의 두 인덱스를 받아 두 위치의 값을 교환
	 * 
	 * @param indexOne 교환할 대상 1
	 * @param indexTwo 교환할 대상 2
	 *
	 */
	private void swap(int indexOne, int indexTwo) {
		int temp = Heap[indexOne];
		Heap[indexOne] = Heap[indexTwo];
		Heap[indexTwo] = temp;
	}

	/**
	 * insert할 때 배열의 크기가 용량과 같으면 이후에 예외를 방지하기 위해 용량을 2배 늘린다.
	 * 
	 */
	private void ensureExtraCapacity() {
		if (size == capacity) {
			Heap = Arrays.copyOf(Heap, capacity * 2);
			capacity *= 2;
		}
	}
}
