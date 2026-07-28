package Board;

public class Boards {
    //The board goes from a1 (0), b1 (1)... etc. to g8 (62), h8 (63)
    public String totalBoard;
    //White pieces
    public long whiteKing;
    public long whiteQueen;
    public long whiteBishops;
    public long whiteKnights;
    public long whiteRooks;
    public long whitePawns;
    //Black pieces
    public long blackKing;
    public long blackQueen;
    public long blackBishops;
    public long blackKnights;
    public long blackRooks;
    public long blackPawns;

    public boolean isValidMove = true;

    public Boards() {

        //White pieces
        this.whiteKing =  createLong(new int[] {4});
        this.whiteQueen = createLong(new int[] {3});
        this.whiteBishops = createLong(new int[] {2, 5});
        this.whiteKnights = createLong(new int[] {1, 6});
        this.whiteRooks = createLong(new int[] {0, 7});
        this.whitePawns = createLong(new int[] {8, 9, 10, 11, 12, 13, 14, 15});

        //Black pieces
        this.blackKing = createLong(new int[] {60});
        this.blackQueen = createLong(new int[] {59});
        this.blackBishops = createLong(new int[] {58, 61});
        this.blackKnights = createLong(new int[] {57, 62});
        this.blackRooks = createLong(new int[] {56, 63});
        this.blackPawns = createLong(new int[] {48, 49, 50, 51, 52, 53, 54, 55});
    }

    public static long createLong(int[] indices){
        long ret = 0L;
        for (int index : indices) {
            ret |= 1L << index;
        }
        return ret;
    }

    public void updateBoard() {
        totalBoard = "";

        String whiteKingStr = String.format("%64s", Long.toBinaryString(whiteKing)).replace(' ', '0');
        String whiteQueenStr = String.format("%64s", Long.toBinaryString(whiteQueen)).replace(' ', '0');
        String whiteBishopsStr = String.format("%64s", Long.toBinaryString(whiteBishops)).replace(' ', '0');
        String whiteKnightsStr = String.format("%64s", Long.toBinaryString(whiteKnights)).replace(' ', '0');
        String whiteRooksStr = String.format("%64s", Long.toBinaryString(whiteRooks)).replace(' ', '0');
        String whitePawnsStr = String.format("%64s", Long.toBinaryString(whitePawns)).replace(' ', '0');

        String blackKingStr = String.format("%64s", Long.toBinaryString(blackKing)).replace(' ', '0');
        String blackQueenStr = String.format("%64s", Long.toBinaryString(blackQueen)).replace(' ', '0');
        String blackBishopsStr = String.format("%64s", Long.toBinaryString(blackBishops)).replace(' ', '0');
        String blackKnightsStr = String.format("%64s", Long.toBinaryString(blackKnights)).replace(' ', '0');
        String blackRooksStr = String.format("%64s", Long.toBinaryString(blackRooks)).replace(' ', '0');
        String blackPawnsStr = String.format("%64s", Long.toBinaryString(blackPawns)).replace(' ', '0');

        for (int i = 0; i < 64; i++) {
            int index = 63 - i;

            if (whiteKingStr.charAt(index) == '1') {
                totalBoard += 'K';
            }
            else if (whiteQueenStr.charAt(index) == '1') {
                totalBoard += 'Q';
            }
            else if (whiteBishopsStr.charAt(index) == '1') {
                totalBoard += 'B';
            }
            else if (whiteKnightsStr.charAt(index) == '1') {
                totalBoard += 'N';
            }
            else if (whiteRooksStr.charAt(index) == '1') {
                totalBoard += 'R';
            }
            else if (whitePawnsStr.charAt(index) == '1') {
                totalBoard += 'P';
            }
            else if (blackKingStr.charAt(index) == '1') {
                totalBoard += 'k';
            }
            else if (blackQueenStr.charAt(index) == '1') {
                totalBoard += 'q';
            }
            else if (blackBishopsStr.charAt(index) == '1') {
                totalBoard += 'b';
            }
            else if (blackKnightsStr.charAt(index) == '1') {
                totalBoard += 'n';
            }
            else if (blackRooksStr.charAt(index) == '1') {
                totalBoard += 'r';
            }
            else if (blackPawnsStr.charAt(index) == '1') {
                totalBoard += 'p';
            }
            else {
                totalBoard += '0';
            }
        }
    }

    public void printBoard(){
        for (int i = 7; i >= 0; i--){
            for (int j = 0; j < 8; j++){
                System.out.print(totalBoard.charAt(i*8+j) + "  ");
            }
            System.out.println();
        }
    }
}
