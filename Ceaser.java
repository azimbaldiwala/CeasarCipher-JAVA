class Ceaser{

    public static void main(String args[]){

        char letters[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        String plain_text = "khoor";    // String to be encrypted or decrypted.
        int key = 3;    // Key --> by default 3 in ceaser cipher.
        int indexs[] = new int[plain_text.length()];       // indexs for new characters.
        String fn_text = ""; // Final string -- output string.

        // Getting index of each char in string. [corresponding number value.]

        for(int i=0; i<plain_text.length(); i++ ){
            
            int ci_temp = get_index(key, plain_text.charAt(i), letters, 'd');   // Get index returns cipher index of the alpahbet with respect to mode [encryption/decryption]
            if(ci_temp == -1){
                System.exit(-1); // If we didnt found index for alphabet then it is not valid character.
            }

            indexs[i] = ci_temp;
        }
        
        // Generating output string.

        for(int i=0; i<plain_text.length(); i++){

            fn_text += letters[indexs[i]];  // letter at index of indexs[i] where indexs of i is index for new character.
        }

        System.out.println(fn_text);       // printing out the final string.

    }

    public static int get_index(int key, char alpha, char [] letters, char opti){

            int index = -1;     // index starts with -1 or if character is not in character array then raise error.
            int i = 0;  // Looping variable i.

            while(i <= 25){
                if(letters[i] == alpha){    // if condition is true we get the index for the alphabet
                    index = i;
                    break;
                }
                i += 1;
            }

            // incrementing index depending on key.
            // ct = (pt + key) % 26 
            if(opti == 'e'){
                int ci_index = (index + key) % 26; // If called in encryption mode 
                return ci_index;
            }
            else{
                int pln_index = (index - key) % 26; // If called in decryption mode
                return pln_index;
            }
    }

}