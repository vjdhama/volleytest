package in.mally.volleytest;
public class Offer {
	
	private String offerHead;
	private String offerDesc;
	private String offerUrl;
	
	Offer(String offerMain, String offerDesc, String offerUrl){
		this.offerHead = offerMain;
		this.offerDesc = offerDesc;
		this.offerUrl = offerUrl;
	}
	
	public String getOfferUrl() {
		return offerUrl;
	}
	
	public String getOfferHead() {
		return offerHead;
	}

	public String getOfferDesc() {
		return offerDesc;
	}

}
