import java.util.*;

/* Project 1: Tic Tac Toe */


public class Main {
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();


    public static void main(String[] args) {
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', ' ', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', ' ', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        printGameBoard(gameBoard);



        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter position (1-9):");
            int playerPos = scan.nextInt();
            while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPositions)) {
                System.out.println("Position taken");
                playerPos = scan.nextInt();
            }
            placePiece(gameBoard, playerPos, "player");
            String result = checkWinner();


            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
                cpuPos = scan.nextInt();
            }
            placePiece(gameBoard, cpuPos, "cpu");

            printGameBoard(gameBoard);


            if(result.length() > 0) {
                System.out.println(result);
                break;
            }

        }

    }


    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();

        }
    }

    public static void placePiece(char[][] gameBoard, int pos, String user) {
        char symbol = ' ';

        if(user.equals("player")) {
            symbol = 'X';
            playerPositions.add(pos);
        } else if(user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(pos);
        }
        switch(pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    public static String checkWinner() {
        //winning row
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        //winning column
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol= Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        //winning diagonal
        List upDiagonal= Arrays.asList(1, 5, 9);
        List downDiagonal = Arrays.asList(7, 5, 3);

        List<List> winningConditions = new ArrayList<List>();
        winningConditions.add(topRow);
        winningConditions.add(midRow);
        winningConditions.add(botRow);
        winningConditions.add(leftCol);
        winningConditions.add(midCol);
        winningConditions.add(rightCol);
        winningConditions.add(upDiagonal);
        winningConditions.add(downDiagonal);

        for(List l : winningConditions) {
            if(playerPositions.containsAll(l)) {
                return "You win";
            } else if(cpuPositions.contains(l)) {
                return "You lose";
            } else if(playerPositions.size() + cpuPositions.size() == 9){
                return "Tie";
            }
        }
        return "";
    }
}

//Source: https://www.youtube.com/watch?v=gQb3dE-y1S4
/* Project Purpose: learn Java */