package algorithms.q0010;

public class Solution001 implements Solution {

	@Override
	public boolean isMatch(String s, String p) {
		if (null == p || "".equals(p)) {
			return s == null ? s == p : s.equals(p);
		}
		return isMatch(s, p, 0, s.length(), 0, p.length());

	}

	public boolean isMatch(String s, String p, int startS, int lenS, int startP, int lenP) {
		int nextIndexP = startP + 1;
		int nextIndexS = startS + 1;
		boolean isMatch = false;
		if (startP >= lenP) {
			return startS == lenS;
		}

		if (startS >= lenS) {
			if(nextIndexP < lenP && p.charAt(nextIndexP) == '*') {
				return isMatch(s, p, startS, lenS, nextIndexP + 1, lenP);
			}
			return false;
		}

		if (isMatch(s.charAt(startS), p.charAt(startP))) {
			if (nextIndexP < lenP) {
				if (p.charAt(nextIndexP) == '*') {
					if (nextIndexP + 1 < lenP) {
						isMatch = isMatch || isMatch(s, p, startS, lenS, nextIndexP + 1, lenP);
						isMatch = isMatch || isMatch(s, p, startS + 1, lenS, startP, lenP);
						return isMatch;
					} else {
						while (nextIndexS < lenS && isMatch(s.charAt(nextIndexS), p.charAt(startP))) {
							nextIndexS++;
						}
						return nextIndexS >= lenS;
					}
				} else {
					return isMatch(s, p, startS + 1, lenS, startP + 1, lenP);
				}
			} else {
				return isMatch(s, p, startS + 1, lenS, startP + 1, lenP);
			}
		} else {
			// return false;
			if (nextIndexP < lenP && p.charAt(nextIndexP) == '*' && nextIndexP + 1 < lenP) {
				return isMatch(s, p, startS, lenS, nextIndexP + 1, lenP);
			} else {
				return false;
			}

		}
	}

	public boolean isMatch(char chS, char chP) {
		return chP == '.' || chP == chS;
	}

}
