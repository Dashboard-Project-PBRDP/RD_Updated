package com.abcode.panchayat.basic;

public class Basic {
	private int id;
	private int panchayat_id;
	private int population;
	private int households;
	private int voters;
	private int wards;
	private String topography;
	private int ponds;
	private String areaPonds;
	private String pondFisheries;
	private String panchayatghar;
	private String panchayatgharType;
	private int reservedDharamshalas;
	private int parks;
	private int dharamshalas;
	private String areaParks;
	private String areaPlaygrounds;
	private String mandiDistance;
	private int playgrounds;
	private int banks;
	private String datelastUpdated;
	
	
	
	public Basic(int id,int panchayat_id,int population, int households, int voters, 
			int wards,String topography,int ponds, String areaPonds, String pondFisheries, String panchayatghar, 
			String panchayatgharType, int dharamshalas, int reservedDharamshalas, int parks,
			String areaParks, int playgrounds, String areaPlaygrounds, String mandiDistance, int banks, String datelastUpdated) {
		super();
		this.id=id;
		this.panchayat_id=panchayat_id;
		this.population=population;
		this.households=households;
		this.voters=voters;
		this.wards=wards;
		this.topography=topography;
		this.ponds=ponds;
		this.areaPonds=areaPonds;
		this.pondFisheries=pondFisheries;
		this.panchayatghar=panchayatghar;
		this.panchayatgharType=panchayatgharType;
		this.dharamshalas=dharamshalas;
		this.reservedDharamshalas=reservedDharamshalas;
		this.parks=parks;
		this.areaParks=areaParks;
		this.playgrounds=playgrounds;
		this.areaPlaygrounds=areaPlaygrounds;
		this.mandiDistance=mandiDistance;
		this.banks=banks;
		this.datelastUpdated=datelastUpdated;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPanchayat_id() {
		return panchayat_id;
	}
	public void setPanchayat_id(int panchayat_id) {
		this.panchayat_id = panchayat_id;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public int getHouseholds() {
		return households;
	}
	public void setHouseholds(int households) {
		this.households = households;
	}
	public int getVoters() {
		return voters;
	}
	public void setVoters(int voters) {
		this.voters = voters;
	}
	public int getWards() {
		return wards;
	}
	public void setWards(int wards) {
		this.wards = wards;
	}
	public String getTopography() {
		return topography;
	}
	public void setTopography(String topography) {
		this.topography = topography;
	}
	public int getPonds() {
		return ponds;
	}
	public void setPonds(int ponds) {
		this.ponds = ponds;
	}
	public String getAreaPonds() {
		return areaPonds;
	}
	public void setAreaPonds(String areaPonds) {
		this.areaPonds = areaPonds;
	}
	public String getPondFisheries() {
		return pondFisheries;
	}
	public void setPondFisheries(String pondFisheries ) {
		this.pondFisheries = pondFisheries;
	}
	public String getPanchayatghar() {
		return panchayatghar;
	}
	public void setPanchayatghar(String panchayatghar ) {
		this.panchayatghar = panchayatghar;
	}
	public String getPanchayatgharType() {
		return panchayatgharType;
	}
	public void setPanchayatgharType(String panchayatgharType ) {
		this.panchayatgharType = panchayatgharType;
	}
	public int getReservedDharamshalas() {
		return reservedDharamshalas;
	}
	public void setReservedDharamshalas(int reservedDharamshalas) {
		this.reservedDharamshalas = reservedDharamshalas;
	}
	public int getParks() {
		return parks;
	}
	public void setParks(int parks) {
		this.parks = parks;
	}
	public int getDharamshalas() {
		return dharamshalas;
	}
	public void setDharamshalas(int dharamshalas) {
		this.dharamshalas = dharamshalas;
	}
	public int getBanks() {
		return banks;
	}
	public void setBanks(int banks) {
		this.banks = banks;
	}
	public int getPlaygrounds() {
		return playgrounds;
	}
	public void setPlaygrounds(int playgrounds) {
		this.playgrounds = playgrounds;
	}
	public String getAreaParks() {
		return areaParks;
	}
	public void setAreaParks(String areaParks) {
		this.areaParks = areaParks;
	}
	public String getAreaPlaygrounds() {
		return areaPlaygrounds;
	}
	public void setAreaPlaygrounds(String areaPlaygrounds ) {
		this.areaPlaygrounds = areaPlaygrounds;
	}
	public String getMandiDistance() {
		return mandiDistance;
	}
	public void setMandiDistance(String mandiDistance ) {
		this.mandiDistance = mandiDistance;
	}
	public String getDatelastUpdated() {
		return datelastUpdated;
	}
	public void setDatelastUpdated(String datelastUpdated ) {
		this.datelastUpdated = datelastUpdated;
	}
	@Override
	public String toString() {
		return "Basic [id=" + id + ", panchayat_id=" + panchayat_id + ", population=" + population + ", households=" + households + ", voters=" + voters + ", wards=" + wards + ", topography=" + topography + ", ponds=" + ponds + ", areaPonds=" + areaPonds + ""
				+ ", pondFisheries=" + pondFisheries + ", panchayatghar=" + panchayatghar + ", panchayatgharType=" + panchayatgharType + ", reservedDharamshalas=" + reservedDharamshalas + ", parks=" + parks + ", areaParks=" + areaParks + ""
						+ ", playgrounds=" + playgrounds + ", areaPlaygrounds=" + areaPlaygrounds + ", mandiDistance=" + mandiDistance + ", banks=" + banks + ", datelastUpdated=" + datelastUpdated + "]";
	}
}
