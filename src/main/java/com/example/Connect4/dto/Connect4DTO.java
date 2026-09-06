package com.example.Connect4.dto;

public class Connect4DTO {
	int[][] board, winningBlocks;
	int whoWon;
	boolean isGameOver;
	public Connect4DTO(int[][] board, int whoWon, boolean isGameOver, int[][] winningBlocks)
	{
		this.board=board;
		this.whoWon=whoWon;
		this.isGameOver=isGameOver;
		this.winningBlocks=winningBlocks;
	}
	public int[][] getBoard() {
		return board;
	}
	public void setBoard(int[][] board) {
		this.board = board;
	}
	public int getWhoWon() {
		return whoWon;
	}
	public void setWhoWon(int whoWon) {
		this.whoWon = whoWon;
	}
	public boolean isGameOver() {
		return isGameOver;
	}
	public void setGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}
	public int[][] getWinningBlocks() {
		return winningBlocks;
	}
	public void setWinningBlocks(int[][] winningBlocks) {
		this.winningBlocks = winningBlocks;
	}
	
}
