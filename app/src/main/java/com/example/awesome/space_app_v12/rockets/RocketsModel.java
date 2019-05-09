package com.example.awesome.space_app_v12.rockets;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RocketsModel {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("stages")
    @Expose
    private Integer stages;
    @SerializedName("boosters")
    @Expose
    private Integer boosters;
    @SerializedName("cost_per_launch")
    @Expose
    private Integer costPerLaunch;
    @SerializedName("success_rate_pct")
    @Expose
    private Integer successRatePct;
    @SerializedName("first_flight")
    @Expose
    private String firstFlight;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("height")
    @Expose
    private Height height;
    @SerializedName("diameter")
    @Expose
    private Diameter diameter;
    @SerializedName("mass")
    @Expose
    private Mass mass;
    @SerializedName("payload_weights")
    @Expose
    private List<PayloadWeight> payloadWeights = null;
    @SerializedName("first_stage")
    @Expose
    private FirstStage firstStage;
    @SerializedName("second_stage")
    @Expose
    private SecondStage secondStage;
    @SerializedName("engines")
    @Expose
    private Engines engines;
    @SerializedName("landing_legs")
    @Expose
    private LandingLegs landingLegs;
    @SerializedName("wikipedia")
    @Expose
    private String wikipedia;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("rocket_id")
    @Expose
    private String rocketId;
    @SerializedName("rocket_name")
    @Expose
    private String rocketName;
    @SerializedName("rocket_type")
    @Expose
    private String rocketType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getStages() {
        return stages;
    }

    public void setStages(Integer stages) {
        this.stages = stages;
    }

    public Integer getBoosters() {
        return boosters;
    }

    public void setBoosters(Integer boosters) {
        this.boosters = boosters;
    }

    public Integer getCostPerLaunch() {
        return costPerLaunch;
    }

    public void setCostPerLaunch(Integer costPerLaunch) {
        this.costPerLaunch = costPerLaunch;
    }

    public Integer getSuccessRatePct() {
        return successRatePct;
    }

    public void setSuccessRatePct(Integer successRatePct) {
        this.successRatePct = successRatePct;
    }

    public String getFirstFlight() {
        return firstFlight;
    }

    public void setFirstFlight(String firstFlight) {
        this.firstFlight = firstFlight;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Height getHeight() {
        return height;
    }

    public void setHeight(Height height) {
        this.height = height;
    }

    public Diameter getDiameter() {
        return diameter;
    }

    public void setDiameter(Diameter diameter) {
        this.diameter = diameter;
    }

    public Mass getMass() {
        return mass;
    }

    public void setMass(Mass mass) {
        this.mass = mass;
    }

    public List<PayloadWeight> getPayloadWeights() {
        return payloadWeights;
    }

    public void setPayloadWeights(List<PayloadWeight> payloadWeights) {
        this.payloadWeights = payloadWeights;
    }

    public FirstStage getFirstStage() {
        return firstStage;
    }

    public void setFirstStage(FirstStage firstStage) {
        this.firstStage = firstStage;
    }

    public SecondStage getSecondStage() {
        return secondStage;
    }

    public void setSecondStage(SecondStage secondStage) {
        this.secondStage = secondStage;
    }

    public Engines getEngines() {
        return engines;
    }

    public void setEngines(Engines engines) {
        this.engines = engines;
    }

    public LandingLegs getLandingLegs() {
        return landingLegs;
    }

    public void setLandingLegs(LandingLegs landingLegs) {
        this.landingLegs = landingLegs;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRocketId() {
        return rocketId;
    }

    public void setRocketId(String rocketId) {
        this.rocketId = rocketId;
    }

    public String getRocketName() {
        return rocketName;
    }

    public void setRocketName(String rocketName) {
        this.rocketName = rocketName;
    }

    public String getRocketType() {
        return rocketType;
    }

    public void setRocketType(String rocketType) {
        this.rocketType = rocketType;
    }


    public class CompositeFairing {

        @SerializedName("height")
        @Expose
        private Height_ height;
        @SerializedName("diameter")
        @Expose
        private Diameter_ diameter;

        public Height_ getHeight() {
            return height;
        }

        public void setHeight(Height_ height) {
            this.height = height;
        }

        public Diameter_ getDiameter() {
            return diameter;
        }

        public void setDiameter(Diameter_ diameter) {
            this.diameter = diameter;
        }

    }

    public class Diameter {

        @SerializedName("meters")
        @Expose
        private Integer meters;
        @SerializedName("feet")
        @Expose
        private Integer feet;

        public Integer getMeters() {
            return meters;
        }

        public void setMeters(Integer meters) {
            this.meters = meters;
        }

        public Integer getFeet() {
            return feet;
        }

        public void setFeet(Integer feet) {
            this.feet = feet;
        }

    }



    public class Diameter_ {

        @SerializedName("meters")
        @Expose
        private Object meters;
        @SerializedName("feet")
        @Expose
        private Object feet;

        public Object getMeters() {
            return meters;
        }

        public void setMeters(Object meters) {
            this.meters = meters;
        }

        public Object getFeet() {
            return feet;
        }

        public void setFeet(Object feet) {
            this.feet = feet;
        }

    }


    public class Engines {

        @SerializedName("number")
        @Expose
        private Integer number;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("version")
        @Expose
        private String version;
        @SerializedName("layout")
        @Expose
        private Object layout;
        @SerializedName("engine_loss_max")
        @Expose
        private Object engineLossMax;
        @SerializedName("propellant_1")
        @Expose
        private String propellant1;
        @SerializedName("propellant_2")
        @Expose
        private String propellant2;
        @SerializedName("thrust_sea_level")
        @Expose
        private ThrustSeaLevel_ thrustSeaLevel;
        @SerializedName("thrust_vacuum")
        @Expose
        private ThrustVacuum_ thrustVacuum;
        @SerializedName("thrust_to_weight")
        @Expose
        private Object thrustToWeight;

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public Object getLayout() {
            return layout;
        }

        public void setLayout(Object layout) {
            this.layout = layout;
        }

        public Object getEngineLossMax() {
            return engineLossMax;
        }

        public void setEngineLossMax(Object engineLossMax) {
            this.engineLossMax = engineLossMax;
        }

        public String getPropellant1() {
            return propellant1;
        }

        public void setPropellant1(String propellant1) {
            this.propellant1 = propellant1;
        }

        public String getPropellant2() {
            return propellant2;
        }

        public void setPropellant2(String propellant2) {
            this.propellant2 = propellant2;
        }

        public ThrustSeaLevel_ getThrustSeaLevel() {
            return thrustSeaLevel;
        }

        public void setThrustSeaLevel(ThrustSeaLevel_ thrustSeaLevel) {
            this.thrustSeaLevel = thrustSeaLevel;
        }

        public ThrustVacuum_ getThrustVacuum() {
            return thrustVacuum;
        }

        public void setThrustVacuum(ThrustVacuum_ thrustVacuum) {
            this.thrustVacuum = thrustVacuum;
        }

        public Object getThrustToWeight() {
            return thrustToWeight;
        }

        public void setThrustToWeight(Object thrustToWeight) {
            this.thrustToWeight = thrustToWeight;
        }

    }

    public class FirstStage {

        @SerializedName("reusable")
        @Expose
        private Boolean reusable;
        @SerializedName("engines")
        @Expose
        private Integer engines;
        @SerializedName("fuel_amount_tons")
        @Expose
        private Integer fuelAmountTons;
        @SerializedName("burn_time_sec")
        @Expose
        private Integer burnTimeSec;
        @SerializedName("thrust_sea_level")
        @Expose
        private ThrustSeaLevel thrustSeaLevel;
        @SerializedName("thrust_vacuum")
        @Expose
        private ThrustVacuum thrustVacuum;
        @SerializedName("cores")
        @Expose
        private Integer cores;

        public Boolean getReusable() {
            return reusable;
        }

        public void setReusable(Boolean reusable) {
            this.reusable = reusable;
        }

        public Integer getEngines() {
            return engines;
        }

        public void setEngines(Integer engines) {
            this.engines = engines;
        }

        public Integer getFuelAmountTons() {
            return fuelAmountTons;
        }

        public void setFuelAmountTons(Integer fuelAmountTons) {
            this.fuelAmountTons = fuelAmountTons;
        }

        public Integer getBurnTimeSec() {
            return burnTimeSec;
        }

        public void setBurnTimeSec(Integer burnTimeSec) {
            this.burnTimeSec = burnTimeSec;
        }

        public ThrustSeaLevel getThrustSeaLevel() {
            return thrustSeaLevel;
        }

        public void setThrustSeaLevel(ThrustSeaLevel thrustSeaLevel) {
            this.thrustSeaLevel = thrustSeaLevel;
        }

        public ThrustVacuum getThrustVacuum() {
            return thrustVacuum;
        }

        public void setThrustVacuum(ThrustVacuum thrustVacuum) {
            this.thrustVacuum = thrustVacuum;
        }

        public Integer getCores() {
            return cores;
        }

        public void setCores(Integer cores) {
            this.cores = cores;
        }

    }

    public class Height {

        @SerializedName("meters")
        @Expose
        private Integer meters;
        @SerializedName("feet")
        @Expose
        private Integer feet;

        public Integer getMeters() {
            return meters;
        }

        public void setMeters(Integer meters) {
            this.meters = meters;
        }

        public Integer getFeet() {
            return feet;
        }

        public void setFeet(Integer feet) {
            this.feet = feet;
        }

    }

    public class Height_ {

        @SerializedName("meters")
        @Expose
        private Object meters;
        @SerializedName("feet")
        @Expose
        private Object feet;

        public Object getMeters() {
            return meters;
        }

        public void setMeters(Object meters) {
            this.meters = meters;
        }

        public Object getFeet() {
            return feet;
        }

        public void setFeet(Object feet) {
            this.feet = feet;
        }

    }

    public class LandingLegs {

        @SerializedName("number")
        @Expose
        private Integer number;
        @SerializedName("material")
        @Expose
        private String material;

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public String getMaterial() {
            return material;
        }

        public void setMaterial(String material) {
            this.material = material;
        }

    }

    public class Mass {

        @SerializedName("kg")
        @Expose
        private Integer kg;
        @SerializedName("lb")
        @Expose
        private Integer lb;

        public Integer getKg() {
            return kg;
        }

        public void setKg(Integer kg) {
            this.kg = kg;
        }

        public Integer getLb() {
            return lb;
        }

        public void setLb(Integer lb) {
            this.lb = lb;
        }

    }

    public class PayloadWeight {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("kg")
        @Expose
        private Integer kg;
        @SerializedName("lb")
        @Expose
        private Integer lb;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getKg() {
            return kg;
        }

        public void setKg(Integer kg) {
            this.kg = kg;
        }

        public Integer getLb() {
            return lb;
        }

        public void setLb(Integer lb) {
            this.lb = lb;
        }

    }

    public class Payloads {

        @SerializedName("option_1")
        @Expose
        private String option1;
        @SerializedName("composite_fairing")
        @Expose
        private CompositeFairing compositeFairing;
        @SerializedName("option_2")
        @Expose
        private String option2;

        public String getOption1() {
            return option1;
        }

        public void setOption1(String option1) {
            this.option1 = option1;
        }

        public CompositeFairing getCompositeFairing() {
            return compositeFairing;
        }

        public void setCompositeFairing(CompositeFairing compositeFairing) {
            this.compositeFairing = compositeFairing;
        }

        public String getOption2() {
            return option2;
        }

        public void setOption2(String option2) {
            this.option2 = option2;
        }

    }

    public class SecondStage {

        @SerializedName("engines")
        @Expose
        private Integer engines;
        @SerializedName("fuel_amount_tons")
        @Expose
        private Integer fuelAmountTons;
        @SerializedName("burn_time_sec")
        @Expose
        private Integer burnTimeSec;
        @SerializedName("thrust")
        @Expose
        private Thrust thrust;
        @SerializedName("payloads")
        @Expose
        private Payloads payloads;

        public Integer getEngines() {
            return engines;
        }

        public void setEngines(Integer engines) {
            this.engines = engines;
        }

        public Integer getFuelAmountTons() {
            return fuelAmountTons;
        }

        public void setFuelAmountTons(Integer fuelAmountTons) {
            this.fuelAmountTons = fuelAmountTons;
        }

        public Integer getBurnTimeSec() {
            return burnTimeSec;
        }

        public void setBurnTimeSec(Integer burnTimeSec) {
            this.burnTimeSec = burnTimeSec;
        }

        public Thrust getThrust() {
            return thrust;
        }

        public void setThrust(Thrust thrust) {
            this.thrust = thrust;
        }

        public Payloads getPayloads() {
            return payloads;
        }

        public void setPayloads(Payloads payloads) {
            this.payloads = payloads;
        }

    }

    public class Thrust {

        @SerializedName("kN")
        @Expose
        private Integer kN;
        @SerializedName("lbf")
        @Expose
        private Integer lbf;

        public Integer getKN() {
            return kN;
        }

        public void setKN(Integer kN) {
            this.kN = kN;
        }

        public Integer getLbf() {
            return lbf;
        }

        public void setLbf(Integer lbf) {
            this.lbf = lbf;
        }

    }

    public class ThrustSeaLevel {

        @SerializedName("kN")
        @Expose
        private Integer kN;
        @SerializedName("lbf")
        @Expose
        private Integer lbf;

        public Integer getKN() {
            return kN;
        }

        public void setKN(Integer kN) {
            this.kN = kN;
        }

        public Integer getLbf() {
            return lbf;
        }

        public void setLbf(Integer lbf) {
            this.lbf = lbf;
        }

    }

    public class ThrustSeaLevel_ {

        @SerializedName("kN")
        @Expose
        private Integer kN;
        @SerializedName("lbf")
        @Expose
        private Integer lbf;

        public Integer getKN() {
            return kN;
        }

        public void setKN(Integer kN) {
            this.kN = kN;
        }

        public Integer getLbf() {
            return lbf;
        }

        public void setLbf(Integer lbf) {
            this.lbf = lbf;
        }

    }

    public class ThrustVacuum {

        @SerializedName("kN")
        @Expose
        private Integer kN;
        @SerializedName("lbf")
        @Expose
        private Integer lbf;

        public Integer getKN() {
            return kN;
        }

        public void setKN(Integer kN) {
            this.kN = kN;
        }

        public Integer getLbf() {
            return lbf;
        }

        public void setLbf(Integer lbf) {
            this.lbf = lbf;
        }

    }

    public class ThrustVacuum_ {

        @SerializedName("kN")
        @Expose
        private Integer kN;
        @SerializedName("lbf")
        @Expose
        private Integer lbf;

        public Integer getKN() {
            return kN;
        }

        public void setKN(Integer kN) {
            this.kN = kN;
        }

        public Integer getLbf() {
            return lbf;
        }

        public void setLbf(Integer lbf) {
            this.lbf = lbf;
        }

    }

}
