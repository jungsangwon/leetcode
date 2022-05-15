class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area = 0;
        area += Math.abs(ax2-ax1) * Math.abs(ay2-ay1);
        // if(ax1==bx1&&ax2==bx2&&ay1==by1&&ay2==by2){
        //     return area;
        // }
        area += Math.abs(bx2-bx1) * Math.abs(by2-by1);
        if(bx1>=ax1&&bx2<=ax2){
            if(by1>=ay1&&by2<=ay2){
                area -= Math.abs(bx2-bx1) * Math.abs(by2-by1);
            }else if(by1<=ay1&&ay2<by2){
                area -= Math.abs(bx2-bx1) * Math.abs(ay2-ay1);
            }else if(by1>=ay1&&by1<ay2){
                area -= Math.abs(bx2-bx1) * Math.abs(ay2-by1);
            }else if(by2>ay1&&by2<=ay2){
                area -= Math.abs(bx2-bx1) * Math.abs(by2-ay1);
            }
        }else if(bx1<=ax1&&bx2>ax2){
             if(by1>=ay1&&by2<=ay2){
                area -= Math.abs(ax2-ax1) * Math.abs(by2-by1);
            }else if(by1<=ay1&&ay2<by2){
                area -= Math.abs(ax2-ax1) * Math.abs(ay2-ay1);
            }else if(by1>=ay1&&by1<ay2){
                area -= Math.abs(ax2-ax1) * Math.abs(ay2-by1);
            }else if(by2>ay1&&by2<=ay2){
                area -= Math.abs(ax2-ax1) * Math.abs(by2-ay1);
            }
        }else if(bx1>=ax1&&bx1<ax2){
            if(by1>=ay1&&by2<=ay2){
                area -= Math.abs(ax2-bx1) * Math.abs(by2-by1);
            }else if(by1<=ay1&&ay2<by2){
                area -= Math.abs(ax2-bx1) * Math.abs(ay2-ay1);
            }else if(by1>=ay1&&by1<ay2){
                area -= Math.abs(ax2-bx1) * Math.abs(ay2-by1);
            }else if(by2>ay1&&by2<=ay2){
                area -= Math.abs(ax2-bx1) * Math.abs(by2-ay1);
            }
        }else if(bx2>ax1&&bx2<=ax2){
            if(by1>=ay1&&by2<=ay2){
                area -= Math.abs(bx2-ax1) * Math.abs(by2-by1);
            }else if(by1<=ay1&&ay2<by2){
                area -= Math.abs(bx2-ax1) * Math.abs(ay2-ay1);
            }else if(by1>=ay1&&by1<ay2){
                area -= Math.abs(bx2-ax1) * Math.abs(ay2-by1);
            }else if(by2>ay1&&by2<=ay2){
                area -= Math.abs(bx2-ax1) * Math.abs(by2-ay1);
            }
        }
        return area;
    }
}