package com.example.WuzzufJobsWebAnalysis;
/*----------------------------------------------------
[File Name]: Analyzer.java
[Authors]: Esraa , Sara ,Sherry
------------------------------------------------------*/
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import tech.tablesaw.api.Table;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Analyzer {

    private Map<String, Long> skills;
    private Map<String, Long> titles;
    private Map<String, Long> company;
    private Map<String, Long> area;
    private Map<String, Long> YearsExp;

    public Analyzer() throws IOException {

        DAO t = new DAO();
        t.DAO("in/Wuzzuf_Jobs.csv");
        Logger.getLogger("org").setLevel(Level.OFF);
        Logger.getLogger("akka").setLevel(Level.OFF);
        t.sumUp();
        this.skills = t.filterBySkills(10);
        this.titles = t.filterByTitle(10);
        this.company = t.filterByCompany(10);
        this.area = t.filterByArea(10);
        //System.out.println(t.filterBySkills(10).print());
        this.YearsExp= t.filterByExperience(10);
        Table tbl =t.getDataSetTable();
        System.out.println(tbl.print(10));
        System.out.println(tbl.structure());

    }

    public Map<String, Long> getSkills(){
        return this.skills;
    }
    public Map<String, Long> getTitles(){
        return this.titles;
    }
    public Map<String, Long> getCompany(){
        return this.company;
    }
    public Map<String, Long> getAreas(){
        return this.area;
    }

    public Map<String, Long> getYearsExp(){
        return this.YearsExp;
    }
}

