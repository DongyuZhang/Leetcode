/*
Method 1 : Combine 2 Arrays and return the middle value. Time: O(m+n) Space: O(m+n)
Method 2 : Binary Search. Time(O(log(m+n))) Space: O(1)
Explaination:
m -> len of A
n -> len of B
i -> number of elements at left of A[i]
j -> number of elements at left of B[j]
We want to separate the whole m+n elements into 2 parts and the maximum value of the
left part is smaller than the minimum value of the right part. At this point the separator
(or average of adjacent separators) will be the median.
To ensure the statement above, we need to ensure:
1. i+j=m-i+n-j(or m-i+n-j+1) (we use the floor value of half length of m+n if odd as i+j )
   we just need to set: 0<=i<=m, j=(m+n+1)/2-i => As j >= 0, when i = m (most likely j<0), 
   we must make sure j=(m+n+1)/2-m >= 0 => n>=m
2. B[j-1] <= A[i] and A[i-1] <= B[j] => make sure max of left part less than min of right part
   (j=0 or i=m or B[j-1]<=A[i]) and (i=0 or j=n or A[i-1]<=B[j])
   (when j=0 or i=m we just need A[i-1]<=B[j], i=0 or j=n the similar)

IF B[j-1]>A[i] => increase i to make A[i] bigger
ELSE IF A[i-1]>B[j] => decrease i to make A[i] smaller
ELSE we get perfect i


*/
class Solution{
	public double findMedianSortedArrays(int[] A, int[] B){
		// make sure A is shorter
		if(A.length > B.length){
			int[] temp = A;
			A = B;
			B = temp;
		}
		int m = A.length, n = B.length;
		int iMin = 0, iMax = m, halfLen = (m+n+1)/2; //half len will be longer if odd
		while(iMin <= iMax){
			int i = (iMin + iMax)/2; // i len will be longer if odd
			int j = halfLen - i;
			if(i < iMax && B[j-1] > A[i]) // i is too small, increase i
				iMin = i+1;
			else if(i > 0 && A[i-1] > B[j]) // i is too big, decrease i
				iMax = i-1;
			else{
				// we found i. Search for MaxLeft and MinRight
				int MaxLeft = 0;
				if(i == 0)
					MaxLeft = B[j-1];
				else if(j == 0)
					MaxLeft = A[i-1];
				else
					MaxLeft = Math.max(A[i-1], B[j-1]);
				// if odd, return max left as half len will be longer at left
				if((m+n)%2==1)
					return MaxLeft;
				int MinRight = 0;
				if(i == m)
					MinRight = B[j];
				else if(j == n)
					MinRight = A[i];
				else
					MinRight = Math.min(A[i], B[j]);
				return (MaxLeft + MinRight)/2.0;
			}
		}
		return 0.0;
	}

	public double findMedianSortedArrays_On(int[] A, int[] B){
		if(A.length == 0 && B.length == 0)
			return 0.0;
		int[] temp = combineSortedArrays(A, B);
		if(temp.length % 2 == 0)
			return (temp[temp.length/2] + temp[temp.length/2-1])/2.0;
		else
			return temp[temp.length/2];
	}
	private int[] combineSortedArrays(int[] A, int[] B){
		int[] res = new int[A.length + b.length];
		int i = 0, j = 0, t = 0;
		while(i < A.length && j < B.length){
			if(A[i]>B[j])
				res[t++] = B[j++];
			else
				res[t++] = A[i++];
		}
		while(i < A.length)
			res[t++] = A[i++];
		while(j < B.length)
			res[t++] = B[j++];
		return res;
	}

	public double findMedianSortedArrays_DivConq(int[] A, int[] B){
		int m = A.length, n = B.length;
		int l = (m+n+1)/2;
		int r = (m+n+2)/2;
		return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r))/2.0;
	}

	private int getkth(int[] A, int aStart, int[] B, int bStart, int k){
		if(aStart >= A.length)
			return B[bStart+k-1];
		if(bStart >= B.length)
			return A[aStart+k-1];
		if(k == 1)
			return Math.min(A[aStart], B[bStart]);

		int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
		if(aStart + k/2 - 1 < A.length)
			aMid = A[aStart + k/2 - 1];
		if(bStart + k/2 - 1 < B.length)
			bMid = B[bStart + k/2 -1];
		if(aMid < bMid)
			return getkth(A, aStart + k/2, B, bStart, k - k/2);
		else
			return getkth(A, aStart, B, bStart + k/2, k - k/2);
	}


}