class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int width = 0;
        for(int height = 1; height <= yellow; height++){
            if(yellow % height != 0){
                continue;
            }
            width = yellow / height;
            System.out.println(width+ " "+height);
            if((height * 2) + (width * 2) + 4 == brown){
                answer = new int[]{width + 2, height + 2};
                break;
            }
            
        }
        return answer;
    }
}