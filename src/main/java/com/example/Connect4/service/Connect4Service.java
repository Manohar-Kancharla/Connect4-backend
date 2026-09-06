package com.example.Connect4.service;

import org.springframework.stereotype.Service;

import com.example.Connect4.dto.Connect4DTO;

@Service
public class Connect4Service {
	int m,n,whoWon,count,required,val;
    int[][] board, winningBlocks;
    int[] last;
    boolean isRed,isGameOver;

    public Connect4Service()
    {
        reset();
    }
    
    public Connect4DTO get()
    {
    	return new Connect4DTO(board,whoWon,isGameOver,winningBlocks);
    }

    public void reset()
    {
        m=6;
        n=7;
        required=4;
        board=new int[m][n];
        last=new int[n];
        winningBlocks=new int[required][2];
        for(int i=0;i<n;i++)
        {
            last[i]=m-1;
        }
        isRed=true;
        isGameOver=false;
        whoWon=0;
        count=0;
    }

    public void checkIsGameOver()
    {
        if(isGameOver)
        {
            return;
        }
        if(count==m*n)
        {
            isGameOver=true;
        }
    }

    public void isWon(int row, int col)
    {
        int val=board[row][col];
        int z,r,c;
        int i=0;
        winningBlocks[i][0]=row;
        winningBlocks[i][1]=col;

        //horizontal
        i=1;
        z=1;
        r=row;
        c=col-1;
        while(c>=0 && board[r][c]==val && z<required)
        {
        	winningBlocks[i][0]=r;
            winningBlocks[i][1]=c;
            i++;
            c--;
            z++;
        }
        c=col+1;
        while(c<n && board[r][c]==val && z<required)
        {
            winningBlocks[i][0]=r;
            winningBlocks[i][1]=c;
            i++;
            c++;
            z++;
        }
        if(z>=required)
        {
            whoWon=val;
            isGameOver=true;
            return;
        }

        //vertical
        i=1;
        z=1;
        r=row-1;
        c=col;
        while(r>=0 && board[r][c]==val && z<required)
        {
            winningBlocks[i][0]=r;
            winningBlocks[i][1]=c;
            i++;
            r--;
            z++;
        }
        r=row+1;
        while(r<m && board[r][c]==val && z<required)
        {
            winningBlocks[i][0]=r;
            winningBlocks[i][1]=c;
            i++;
            r++;
            z++;
        }
        if(z>=required)
        {
            whoWon=val;
            isGameOver=true;
            return;
        }

        //top left to bottom right diagnoal
        i=1;
        z=1;
        r=row-1;
        c=col-1;
        while(r>=0 && c>=0 && board[r][c]==val && z<required)
        {
            winningBlocks[i][0]=r;
            winningBlocks[i][1]=c;
            i++;
            r--;
            c--;
            z++;
        }
        r=row+1;
        c=col+1;
        while(r<m && c<n && board[r][c]==val && z<required)
        {
            winningBlocks[i][0]=r;
            winningBlocks[i][1]=c;
            i++;
            r++;
            c++;
            z++;
        }
        if(z>=required)
        {
            whoWon=val;
            isGameOver=true;
            return;
        }

        //top right to bottom left diagnoal
        i=1;
        z=1;
        r=row-1;
        c=col+1;
        while(r>=0 && c<n && board[r][c]==val && z<required)
        {
            winningBlocks[i][0]=r;
            winningBlocks[i][1]=c;
            i++;
            r--;
            c++;
            z++;
        }
        r=row+1;
        c=col-1;
        while(r<m && c>=0 && board[r][c]==val && z<required)
        {
            winningBlocks[i][0]=r;
            winningBlocks[i][1]=c;
            i++;
            r++;
            c--;
            z++;
        }
        if(z>=required)
        {
            whoWon=val;
            isGameOver=true;
            return;
        }
    }

    public void run(int row, int col)
    {
        if(isGameOver || row<0 || col<0 || col>=n || row>last[col])
        {
            return;
        }
        row=last[col];
        last[col]--;
        if(isRed)
        {
            val=1;
        }
        else
        {
            val=2;
        }
        isRed=!isRed;
        board[row][col]=val;
        count++;
        isWon(row, col);
        checkIsGameOver();
    }
}
