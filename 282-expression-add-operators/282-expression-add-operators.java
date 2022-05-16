class Solution
{
    public List<String> addOperators(String num, int target)
    {
        List<String> result = new ArrayList<>();
        if (target == Integer.MIN_VALUE) return result;
        
        // using char array to avoid more space consuming by string
        char[] originalChars = num.toCharArray();
        int len = num.length();
        
        // the maximum length of the new string with operators is 2 * len - 1(1 + 1 + 2)
        // add an operator in between each character
        char[] newChars = new char[len + len - 1];
        
        // originalIndex: the index we use to track in original num.
        int originalIndex = 0;
        
        // newIndex: the index we use to track in new formed string with operators.
        int newIndex = 0;
        
        int currentValue = 0;   // the current operand value.
        
        long targetL = target;  // avoid overflow.
        
        // The first operand is without operator before it.
        for (int i = 0; i < len; i++)
        {
            // current value can be multiple digits.
            currentValue = 10 * currentValue + (originalChars[i] - '0');
            
            // form new string with operators.
            newChars[newIndex++] = originalChars[i];
            
            // using helper function formOperator to process the rest (recursion)
            formOperator(result, originalChars, newChars, i + 1, newIndex, len, 0, currentValue, targetL);
            
            if (currentValue == 0) break;   // can only has single digit: 0 if value == 0, no need to calculate multiple digits.
        }
        
        return result;
    }
    
    // ......pre_preSum (+) preValue <operator> currentValue;
    // if (+) is (-), the preValue will be -preValue;
    // if <operator> is (*), then pre_presSum stays, first calculate preValue * currentValue;
    
    private void formOperator(List<String> result, char[] originalChars, char[] newChars, 
                              int originalIndex, int newIndex, int len,
                              long pre_preSum, long preValue, long targetL)
    {
        // already reach to the end of the original chars.
        if (originalIndex == len)
        {
            if (pre_preSum + preValue == targetL)
            {
                result.add(new String(newChars, 0, newIndex));
            }
            
            return;
        }
        
        long currentValue = 0;
        int operatorIndex = newIndex++;
        
        for (int i = originalIndex; i < len; i++)
        {
            // current value can be multiple digits.
            currentValue = 10 * currentValue + (originalChars[i] - '0');
            
            // form new string with operators.
            newChars[newIndex++] = originalChars[i];
            
            newChars[operatorIndex] = '+';
            formOperator(result, originalChars, newChars, i + 1, newIndex, len, pre_preSum + preValue, currentValue, targetL);
            
            newChars[operatorIndex] = '-';
            formOperator(result, originalChars, newChars, i + 1, newIndex, len, pre_preSum + preValue, -currentValue, targetL);
            
            newChars[operatorIndex] = '*';
            formOperator(result, originalChars, newChars, i + 1, newIndex, len, pre_preSum, preValue * currentValue, targetL);
            
            if (currentValue == 0) break;   // no leading zeros(multiple digits).
        }
    }
}