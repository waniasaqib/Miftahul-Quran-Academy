package com.example.test;

public class StudentProgress {
	  
	  //instance variables
	  //program
	  private String programChosen;

	  //progress
	  private String progressOfStudentDaily;
	  private String progressOfStudentMonthly;

	  private String lastRecord = "";

	  //sapara
	  private Boolean[] sabaqDoneOrNot = new Boolean[30];
	  private Boolean todaySabaqDoneOrNot;
	  private int[] linesMemorized = new int[30];
	  private int todayLinesMemorized;
	  private int[] mistakesMade = new int[30];
	  private int todayMistakesMade;
	  private Boolean[] numOfSaparasDoneMonth = new Boolean[30];
	  private Boolean todaySaparaFinished;
	  //if yes then add one to totalsaparadone
	  private int[] nameOfSaparasDoneMonth = new int[30];
	  private int totalSaparasDone;
	  private int todaySaparaDone;
	  //and add one to saparas done
	  //COME BACK IF MORE THAN 30 THEN URGE QARI TO CHANGE STUDENT TO HAFIZ PROGRAM
	  private String saparasDone;
	  //run through array and see if new sapara entered already exists
	  private int currentSaparaMemorizing;
	  private int saparaNextFill = 0;

	  //dour
	  private Boolean[] dourDoneOrNot = new Boolean[30];
	  private Boolean todayDourDoneOrNot;
	  private int[] quarterNumDoneMonth = new int[30];
	  private int todayQuartersDone;
	  private int currentQuarter;
	  //if quarter done plus current quarter is more than 4, then ask for new current sapara and add current sapara to dour saparas done. Assign the % of the total to current quarter.
	  private Boolean[] numOfDourSaparasDoneMonth = new Boolean[30];
	  private Boolean todayDourSaparaDoneOrNot;
	  private int todayDourSaparaDone;
	  //this is just the last current sapara

	  //private String dourSaparaDone;
	  private int dourCurrentSapara;
	  private int dourNextFill = 0;

	  


	  //constructors
	  public StudentProgress(String programChosen, Boolean[] sabaqDoneOrNot, int[] linesMemorized, int[] mistakesMade, Boolean[] numOfSaparasDoneMonth, int[] nameOfSaparasDoneMonth, int totalSaparasDone, String saparasDone, int currentSaparaMemorizing, Boolean[] dourDoneOrNot, int[] quarterNumDoneMonth, int currentQuarter, Boolean[] numOfDourSaparasDoneMonth, int dourCurrentSapara, String teacherComment) {

	    this.programChosen = programChosen;
	    this.sabaqDoneOrNot = sabaqDoneOrNot;
	    this.linesMemorized = linesMemorized;
	    this.mistakesMade = mistakesMade;
	    this.numOfSaparasDoneMonth = numOfSaparasDoneMonth;
	    this.nameOfSaparasDoneMonth =  nameOfSaparasDoneMonth;
	    this.totalSaparasDone = totalSaparasDone;
	    this.saparasDone = saparasDone;
	    this.currentSaparaMemorizing = currentSaparaMemorizing;
	    this.dourDoneOrNot= dourDoneOrNot;
	    this.quarterNumDoneMonth = quarterNumDoneMonth;
	    this.currentQuarter = currentQuarter;
	    this.numOfDourSaparasDoneMonth = numOfDourSaparasDoneMonth;
	    this.dourCurrentSapara = dourCurrentSapara;

	  }

	  public StudentProgress (String programChosen,
				String lastRecord, Boolean[] sabaqDoneOrNot, Boolean todaySabaqDoneOrNot, int[] linesMemorized,
				int todayLinesMemorized, int[] mistakesMade, int todayMistakesMade, Boolean[] numOfSaparasDoneMonth,
				Boolean todaySaparaFinished, int[] nameOfSaparasDoneMonth, int totalSaparasDone, int todaySaparaDone,
				String saparasDone, int currentSaparaMemorizing, int saparaNextFill, Boolean[] dourDoneOrNot,
				Boolean todayDourDoneOrNot, int[] quarterNumDoneMonth, int todayQuartersDone, int currentQuarter,
				Boolean[] numOfDourSaparasDoneMonth, Boolean todayDourSaparaDoneOrNot, int todayDourSaparaDone,
				int dourCurrentSapara, int dourNextFill, String teacherComment) {
	        super();
			this.programChosen = programChosen;
			this.lastRecord = lastRecord;
			this.sabaqDoneOrNot = sabaqDoneOrNot;
			this.todaySabaqDoneOrNot = todaySabaqDoneOrNot;
			this.linesMemorized = linesMemorized;
			this.todayLinesMemorized = todayLinesMemorized;
			this.mistakesMade = mistakesMade;
			this.todayMistakesMade = todayMistakesMade;
			this.numOfSaparasDoneMonth = numOfSaparasDoneMonth;
			this.todaySaparaFinished = todaySaparaFinished;
			this.nameOfSaparasDoneMonth = nameOfSaparasDoneMonth;
			this.totalSaparasDone = totalSaparasDone;
			this.todaySaparaDone = todaySaparaDone;
			this.saparasDone = saparasDone;
			this.currentSaparaMemorizing = currentSaparaMemorizing;
			this.saparaNextFill = saparaNextFill;
			this.dourDoneOrNot = dourDoneOrNot;
			this.todayDourDoneOrNot = todayDourDoneOrNot;
			this.quarterNumDoneMonth = quarterNumDoneMonth;
			this.todayQuartersDone = todayQuartersDone;
			this.currentQuarter = currentQuarter;
			this.numOfDourSaparasDoneMonth = numOfDourSaparasDoneMonth;
			this.todayDourSaparaDoneOrNot = todayDourSaparaDoneOrNot;
			this.todayDourSaparaDone = todayDourSaparaDone;
			this.dourCurrentSapara = dourCurrentSapara;
			this.dourNextFill = dourNextFill;
	      }

	  public StudentProgress() {
	    
	  }

	  public StudentProgress(String programChosen, String saparasDone, int totalSaparasDone, int currentSaparaMemorizing, int dourCurrentQuarter, int dourCurrentSapara) {
	    this.programChosen = programChosen;
	    this.saparasDone = saparasDone;
	    this.totalSaparasDone = totalSaparasDone;
	    this.currentSaparaMemorizing = currentSaparaMemorizing;
	    this.currentQuarter = dourCurrentQuarter;
	    this.dourCurrentSapara = dourCurrentSapara;
	  }
	  



	  //getters and setters

	  //PROGRAM CHOSEN 
	  public String getProgramChosen() {
	    return programChosen;
	  }
	  public void setProgramChosen(String programChosen) {
	    this.programChosen = programChosen;
	  }


	    //SABAQ

	  public Boolean[] getSabaqDoneOrNot() {
				return sabaqDoneOrNot;
			}

			public void setSabaqDoneOrNot(Boolean[] sabaqDoneOrNot) {
				this.sabaqDoneOrNot = sabaqDoneOrNot;
			}
	    

			public Boolean getTodaySabaqDoneOrNot() {
				return todaySabaqDoneOrNot;
			}

			public void setTodaySabaqDoneOrNot(Boolean todaySabaqDoneOrNot) {
				this.todaySabaqDoneOrNot = todaySabaqDoneOrNot;
	      saparaNextFill++;
	      sabaqDoneOrNot[saparaNextFill%30] = todaySabaqDoneOrNot;
	      }

			public int[] getLinesMemorized() {
				return linesMemorized;
			}

			public void setLinesMemorized(int[] linesMemorized) {
				this.linesMemorized = linesMemorized;
			}

			public int getTodayLinesMemorized() {
				return todayLinesMemorized;
			}

			public void setTodayLinesMemorized(int todayLinesMemorized) {
				this.todayLinesMemorized = todayLinesMemorized;
	      linesMemorized[saparaNextFill%30] = todayLinesMemorized;
			}

			public int[] getMistakesMade() {
				return mistakesMade;
			}

			public void setMistakesMade(int[] mistakesMade) {
				this.mistakesMade = mistakesMade;
			}

			public int getTodayMistakesMade() {
				return todayMistakesMade;
			}

			public void setTodayMistakesMade(int todayMistakesMade) {
				this.todayMistakesMade = todayMistakesMade;
	      mistakesMade [saparaNextFill%30] = todayMistakesMade;
			}

			public Boolean[] getNumOfSaparasDoneMonth() {
				return numOfSaparasDoneMonth;
			}

			public void setNumOfSaparasDoneMonth(Boolean[] numOfSaparasDoneMonth) {
				this.numOfSaparasDoneMonth = numOfSaparasDoneMonth;
			}

			public Boolean isTodaySaparaFinished() {
				return todaySaparaFinished;
			}

			public void setTodaySaparaFinished(Boolean todaySaparaFinished) {
				this.todaySaparaFinished = todaySaparaFinished;
	      numOfSaparasDoneMonth [saparaNextFill%30] = todaySaparaFinished;
	      totalSaparasDone++;
	      if (todaySaparaFinished == false) {
	        setTodaySaparaDone(0);
	      }
			}

			public int[] getNameOfSaparasDoneMonth() {
				return nameOfSaparasDoneMonth;
			}

			public void setNameOfSaparasDoneMonth(int [] nameOfSaparasDoneMonth) {
				this.nameOfSaparasDoneMonth = nameOfSaparasDoneMonth;
			}

			public int getTotalSaparasDone() {
				return totalSaparasDone;
			}

			public void setTotalSaparasDone(int totalSaparasDone) {
				this.totalSaparasDone = totalSaparasDone;
			}

			public int getTodaySaparaDone() {
				return todaySaparaDone;
			}

			public void setTodaySaparaDone(int todaySaparaDone) {
				this.todaySaparaDone = todaySaparaDone;
	      if (todaySaparaDone != 0) {
	      totalSaparasDone++;
	      }
	      nameOfSaparasDoneMonth [saparaNextFill%30] = todaySaparaDone;
			}

			public String getSaparasDone() {
				return saparasDone;
			}

			public void addSaparasDone(int saparasDoneNow) {
	      if (saparasDone.equals(null)) {
	        saparasDone = "" + saparasDoneNow;
	      } else {
				saparasDone = saparasDone + ", " + saparasDoneNow;
	      }
			}

			public int getCurrentSaparaMemorizing() {
				return currentSaparaMemorizing;
			}

			public void setCurrentSaparaMemorizing(int currentSaparaMemorizing) {
				this.currentSaparaMemorizing = currentSaparaMemorizing;
			}

	    //DOUR
			public Boolean[] getDourDoneOrNot() {
				return dourDoneOrNot;
			}

			public void setDourDoneOrNot(Boolean[] dourDoneOrNot) {
				this.dourDoneOrNot = dourDoneOrNot;
			}

			public Boolean isTodayDourDoneOrNot() {
				return todayDourDoneOrNot;
			}

			public void setTodayDourDoneOrNot(Boolean todayDourDoneOrNot) {
				this.todayDourDoneOrNot = todayDourDoneOrNot;
	      dourNextFill++;
	      dourDoneOrNot[dourNextFill%30] = todayDourDoneOrNot;
			}

			public int[] getQuarterNumDoneMonth() {
				return quarterNumDoneMonth;
			}

			public void setQuarterNumDoneMonth(int[] quarterNumDoneMonth) {
				this.quarterNumDoneMonth = quarterNumDoneMonth;
			}

			public int getTodayQuartersDone() {
				return todayQuartersDone;
			}

			public void setTodayQuartersDone(int todayQuartersDone) {
				this.todayQuartersDone = todayQuartersDone;
	      quarterNumDoneMonth [dourNextFill%30] = todayQuartersDone;
			}

			public int getCurrentQuarter() {
				return currentQuarter;
			}

			public void setCurrentQuarter(int currentQuarter) {
				this.currentQuarter = currentQuarter;
			}

			public Boolean[] getNumOfDourSaparasDoneMonth() {
				return numOfDourSaparasDoneMonth;
			}

			public void setNumOfDourSaparasDoneMonth(Boolean[] numOfDourSaparasDoneMonth) {
				this.numOfDourSaparasDoneMonth = numOfDourSaparasDoneMonth;
			}

			public Boolean isTodayDourSaparaDoneOrNot() {
				return todayDourSaparaDoneOrNot;
			}

			public void setTodayDourSaparaDoneOrNot(Boolean todayDourSaparaDoneOrNot) {
				this.todayDourSaparaDoneOrNot = todayDourSaparaDoneOrNot;
	      numOfDourSaparasDoneMonth [dourNextFill%30] = todayDourSaparaDoneOrNot;
	      if (todayDourSaparaDoneOrNot == false) {
	        setTodayDourSaparaDone(0);
	      }

			}

			public int getTodayDourSaparaDone() {
				return todayDourSaparaDone;
			}

			public void setTodayDourSaparaDone(int todayDourSaparaDone) {
				this.todayDourSaparaDone = todayDourSaparaDone;
			}

			public int getDourCurrentSapara() {
				return dourCurrentSapara;
			}

			public void setDourCurrentSapara(int dourCurrentSapara) {
				this.dourCurrentSapara = dourCurrentSapara;
			}

	     //OTHER

	    
	    //SETTERS FOR FILE OPEN
	    public void setOpenProgramChosen(String programChosen) {
			this.programChosen = programChosen;
		}

		public void setOpenProgressOfStudentDaily(String progressOfStudentDaily) {
			this.progressOfStudentDaily = progressOfStudentDaily;
		}

		public void setOpenProgressOfStudentMonthly(String progressOfStudentMonthly) {
			this.progressOfStudentMonthly = progressOfStudentMonthly;
		}

		public void setOpenSabaqDoneOrNot(Boolean[] sabaqDoneOrNot) {
			this.sabaqDoneOrNot = sabaqDoneOrNot;
		}

		public void setOpenTodaySabaqDoneOrNot(Boolean todaySabaqDoneOrNot) {
			this.todaySabaqDoneOrNot = todaySabaqDoneOrNot;
		}

		public void setOpenLinesMemorized(int[] linesMemorized) {
			this.linesMemorized = linesMemorized;
		}

		public void setOpenTodayLinesMemorized(int todayLinesMemorized) {
			this.todayLinesMemorized = todayLinesMemorized;
		}

		public void setOpenMistakesMade(int[] mistakesMade) {
			this.mistakesMade = mistakesMade;
		}

		public void setOpenTodayMistakesMade(int todayMistakesMade) {
			this.todayMistakesMade = todayMistakesMade;
		}

		public void setOpenNumOfSaparasDoneMonth(Boolean[] numOfSaparasDoneMonth) {
			this.numOfSaparasDoneMonth = numOfSaparasDoneMonth;
		}

		public void setOpenTodaySaparaFinished(Boolean todaySaparaFinished) {
			this.todaySaparaFinished = todaySaparaFinished;
		}

		public void setOpenNameOfSaparasDoneMonth(int[] nameOfSaparasDoneMonth) {
			this.nameOfSaparasDoneMonth = nameOfSaparasDoneMonth;
		}

		public void setOpenTotalSaparasDone(int totalSaparasDone) {
			this.totalSaparasDone = totalSaparasDone;
		}

		public void setOpenTodaySaparaDone(int todaySaparaDone) {
			this.todaySaparaDone = todaySaparaDone;
		}

		public void setOpenSaparasDone(String saparasDone) {
			this.saparasDone = saparasDone;
		}

		public void setOpenCurrentSaparaMemorizing(int currentSaparaMemorizing) {
			this.currentSaparaMemorizing = currentSaparaMemorizing;
		}

		public void setOpenSaparaNextFill(int saparaNextFill) {
			this.saparaNextFill = saparaNextFill;
		}

		public void setOpenDourDoneOrNot(Boolean[] dourDoneOrNot) {
			this.dourDoneOrNot = dourDoneOrNot;
		}

		public void setOpenTodayDourDoneOrNot(Boolean todayDourDoneOrNot) {
			this.todayDourDoneOrNot = todayDourDoneOrNot;
		}

		public void setOpenQuarterNumDoneMonth(int[] quarterNumDoneMonth) {
			this.quarterNumDoneMonth = quarterNumDoneMonth;
		}

		public void setOpenTodayQuartersDone(int todayQuartersDone) {
			this.todayQuartersDone = todayQuartersDone;
		}

		public void setOpenCurrentQuarter(int currentQuarter) {
			this.currentQuarter = currentQuarter;
		}

		public void setOpenNumOfDourSaparasDoneMonth(Boolean[] numOfDourSaparasDoneMonth) {
			this.numOfDourSaparasDoneMonth = numOfDourSaparasDoneMonth;
		}

		public void setOpenTodayDourSaparaDoneOrNot(Boolean todayDourSaparaDoneOrNot) {
			this.todayDourSaparaDoneOrNot = todayDourSaparaDoneOrNot;
		}

		public void setOpenTodayDourSaparaDone(int todayDourSaparaDone) {
			this.todayDourSaparaDone = todayDourSaparaDone;
		}

		public void setOpenDourCurrentSapara(int dourCurrentSapara) {
			this.dourCurrentSapara = dourCurrentSapara;
		}

		public void setOpenDourNextFill(int dourNextFill) {
			this.dourNextFill = dourNextFill;
		}


	    //METHODS

	    public static int timesNotDone(Boolean[] array) {
	      int times = 0;
	      for (int i = 0; i < array.length; i++) {
	        if (array [i] == false) {
	        times++;
	        }
	      }
	      return times;
	    }

	    public static int timesDone(Boolean[] array) {
	      int times = 0;
	      for (int i = 0; i < array.length; i++) {
	        if (array [i] == true) {
	        times++;
	        }
	      }
	      return times;
	    }

	    public static int findAverage(int [] array) {
	      int average = 0;
	      int total = 0;
	      int counter = 0;
	      for (int i = 0; i < array.length; i++) {
	        total = total + array [i];
	        counter ++;
	      }
	      average = total/counter;

	      return average;
	    } 

	    

	    public static int findTotal(int [] array) {
	      int total = 0;
	      for (int i = 0; i < array.length; i++) {
	        total = total + array [i];
	      }
	      return total;
	    }

	    public static String findName(int [] array) {
	      String name = "";
	      for (int i = 0; i < array.length; i++) {
	        if (array [i] != 0) {
	          name = name + array [i] + ", ";
	        }
	      }
	      return name;

	    }

	    public String getLastRecord() {
			return lastRecord;
		}

		public void setLastRecord(String lastRecord) {
			this.lastRecord = lastRecord;
		}

	  public int getSaparaNextFill() {
	    return saparaNextFill;
	  }

	  public int getDourNextFill() {
	    return dourNextFill;
	  }

	  
	}
