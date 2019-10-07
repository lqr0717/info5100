package a4;

public class PsychiatristObject {
	public void examine(MoodyObject moodyObject) {
	        System.out.println("How are you feeling today?");
	        System.out.println("I feel " + moodyObject.getMood() + " today!");
	        System.out.println("");
	    }
	    public void observe(MoodyObject moodyObject) {
	        moodyObject.expressFeelings();
	        System.out.println("Observation: " + moodyObject.toString());
	        System.out.println("");
	    }
	    public static void main(String[] args){
	    	PsychiatristObject psy = new PsychiatristObject();
	    	MoodyObject sad = new SadObject();
	    	MoodyObject happy = new HappyObject();
	    	psy.examine(happy);
	    	psy.observe(happy);
	    	psy.examine(sad);
	    	psy.observe(sad);
	    	}
}
