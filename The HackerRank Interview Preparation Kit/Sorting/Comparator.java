

class Checker implements Comparator<Player> {
  	// complete this method
	public int compare(Player a, Player b) {
        if(a.score>b.score){
            return -1;
        }
        else if(a.score<b.score){
            return 1;
        }
        else{
            String x = a.name;
            String y = b.name;
            if(x.compareTo(y)==0)
                return 0;
            else if(x.compareTo(y)>0)
                return 1;
            else
                return -1;
        }
    }
}

//just implemented the comparator
