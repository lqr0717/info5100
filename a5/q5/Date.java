package Date;

public class Date {
	private int Month,Day,Year;
	public Date(int m, int d,int y) {
		this.Month = m;
		this.Day = d;
		this.Year = y;
	}
	public boolean behindDate(Date d) {
		if(this.Year< d.Year) {
			return true;
		}else if(this.Year == d.Year) {
			if (this.Month < d.Month) {
				return true;
			}else if (this.Month == d.Month) {
				if(this.Day<=d.Day) {
					return true;
				}
			}
		}
		
		return false;
		
	}
	public boolean aheadDate(Date d) {
		if(this.Year> d.Year) {
			return true;
		}else if(this.Year == d.Year) {
			if (this.Month > d.Month) {
				return true;
			}else if (this.Month == d.Month) {
				if(this.Day >= d.Day) {
					return true;
				}
			}
		}
		
		return false;
		
	}
}
