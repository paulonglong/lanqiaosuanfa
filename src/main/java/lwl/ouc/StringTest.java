package lwl.ouc;

public class StringTest {
    public static void main(String[] args) {
        char[] source = {'1', 'w', '2', 'e', '3', 'r', '4', 't'};
        char[] target = {'e', 'r'};
        indexOf(source, 0, source.length, target, 0, target.length, 0);
    }

    /**
     * 
     * @param source
     * @param sourceOffset
     * @param sourceCount
     * @param target
     * @param targetOffset
     * @param targetCount
     * @param fromIndex
     * @return
     */
    static int indexOf(char[] source, int sourceOffset, int sourceCount, 
        char[] target, int targetOffset, int targetCount, int fromIndex) {
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }

        char first = target[targetOffset];
        int max = sourceOffset + (sourceCount - targetCount);

        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j] == target[k]; j++, k++);

                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }
}
