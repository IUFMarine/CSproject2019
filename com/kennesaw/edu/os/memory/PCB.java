package com.kennesaw.edu.os.memory;

import java.io.*; 
public class PCB
{
   int cpuID;
   String Status;
   int counter;
   int priority;
   int startingAddress;
   char PC;
   
   public enum Status
   {
      RUNNING(0), READY(1), BLOCKED(2), NEW(3), TERMINATED(4);
      
      public int Status_TYPE;
      
      Status(int Status_NUM) {
         Status_TYPE = Status_NUM;
      }
      
      public int getStatus_NUM() {
         return this.Status_TYPE;
      }
   }
   

   //Total wating time
   long startWaitingTime = 0;
   long endWaitingTime = 0;
   long totalWaitingTime = 0;   
   //Total running time
   long startRunningTime = 0;
   long endRunningTime = 0;
   long totalRunningTime = 0;
   
   Status status;
   
   
   public void Times() 
   {
        //Waiting time measurement---- NEW, BLOCKED, and READY
        if(status.getStatus_NUM() == 1 || status.getStatus_NUM() == 2 || status.getStatus_NUM() == 3)
         {       //Waiting Time
                startWaitingTime = System.nanoTime();
                if(status.getStatus_NUM() != 1 || status.getStatus_NUM() != 2 || status.getStatus_NUM() != 3)
                {
                   endWaitingTime = System.nanoTime();
                }
                
               totalWaitingTime += endWaitingTime - startWaitingTime;
          }
          //When it is running status 
          else if(status.getStatus_NUM() == 0)
          {
                //Running Time
                startRunningTime = System.nanoTime();
                //Add a process
                if(status.getStatus_NUM() != 0)
                {
                   endRunningTime = System.nanoTime();
                }
                
               totalRunningTime += endRunningTime - startRunningTime;
          }
          //When it is terminated
          else
          {
           System.out.println("Terminated");
           System.out.println("Total Running Time : " + totalRunningTime);
           System.out.println("Total Waiting Time : " + totalWaitingTime);
          }
      }          
   //Setters and getters
   public void setPC(char PC)
   {
      this.PC = PC;
   }
   public int getPC()
   {
     return this.PC;
   }
   
   public void setcpuID(int cpuID)
   {
      this.cpuID = cpuID;
   }
   public int getcpuID()
   {
     return this.cpuID;
   }
 
   
   public void setPriority(int priority)
   {
      this.priority = priority;
   }
   public int gePriority()
   {
     return this.priority;
   }
   
   public void setStartingAddress(int startingAddress)
   {
      this.startingAddress = startingAddress;
   }  
   
   public int getStartingAddress()
   {
     return this.startingAddress;
   }


   public PCB(int cpuID, String State, int counter, int priority, int startingAddress )
   {
      this.cpuID = cpuID;
      this.Status = Status;
      this.counter = counter;
      this.priority = priority;
      this.startingAddress = startingAddress;

   }

}

