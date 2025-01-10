package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List; // imported recently

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {

    private final ChessGame.TeamColor pieceColor;
    private final PieceType type;

    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this.pieceColor = pieceColor;
        this.type = type;
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        return pieceColor;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        return type;
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        if (this.type == PieceType.ROOK) {
            //call rook move method in Rook class
        } else if (this.type == PieceType.BISHOP) {
            //call bishop move method in bishop class
        }
        return new ArrayList<>();
    }

    /* Bishop Piece */
    public static class Bishop extends ChessPiece {
        public Bishop(ChessGame.TeamColor pieceColor) {
            super(pieceColor, PieceType.BISHOP);
        }

        @Override
        public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {

            return new ArrayList<>();

            //return java.util.List.of();
        }
    }

    /* Rook Piece */
    public static class Rook extends ChessPiece {
        public Rook(ChessGame.TeamColor pieceColor) {
            super(pieceColor, PieceType.ROOK);
        }

        @Override
        public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {

            List<ChessMove> possibleMoves = new ArrayList<>();
//            int[] rowDir = {-1, 1, 0, 0}; // Up, Down
//            int[] colDir = {0, 0, -1, 1}; // Left, Right


            for (int row = myPosition.getRow(); row <= 8; ++row) {
                ChessPosition position = new ChessPosition(row, myPosition.getColumn());
                ChessPiece piece = board.getPiece(position);
                if(piece == null) {
                    ChessMove move = new ChessMove(myPosition, position, null);
                    possibleMoves.add(move);
                } else {
                    if (this.getTeamColor() != piece.getTeamColor()) {
                        ChessMove move = new ChessMove(myPosition, position, null);
                        possibleMoves.add(move);
                    }
                    break;
                }
            }

            //repeat for column.
            for (int col = myPosition.getColumn(); col <= 8; ++col) {
                ChessPosition position = new ChessPosition(myPosition.getRow(), col);
                ChessPiece piece = board.getPiece(position);
                if(piece == null) {
                    ChessMove move = new ChessMove(myPosition, position, null);
                    possibleMoves.add(move);
                } else {
                    if (this.getTeamColor() != piece.getTeamColor()) {
                        ChessMove move = new ChessMove(myPosition, position, null);
                        possibleMoves.add(move);
                    }
                    break;
                }
            }



            //check if out of bounds

            //check is square is empty or can capture?
            return possibleMoves;
        }
    }
}
