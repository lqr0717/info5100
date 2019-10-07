package a4;

public abstract class MoodyObject {
    
    protected abstract String getMood();

    protected abstract void expressFeelings();
  
    public void queryMood() {

    }
}

class HappyObject extends MoodyObject {
	@Override
    protected String getMood() {
        return "happy";
    }
    @Override
    public void expressFeelings() {
        System.out.println("hehehe...hahahah...HAHAHAHAHA!!!");
    }
    
    public String toString() {
        return "Subject laughs a lot";
    }

}

class SadObject extends MoodyObject {
	@Override
    protected String getMood() {
        return "sad";
    }
	@Override
    public void expressFeelings() {
        System.out.println(" 'wah' 'boo hoo' 'weep' 'sob' 'weep'");
    }
    
    public String toString() {
        return "Subject cries a lot";
    }
}




