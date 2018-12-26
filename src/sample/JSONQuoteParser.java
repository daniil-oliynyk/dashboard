package sample;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSONQuoteParser {

    private String name;
    private String symbol;
    private String circ_supply;
    private String max_supply;
    private String cmc_rank;
    private String price;
    private String volume24h;
    private String percent1h;
    private String percent24h;
    private String percent7d;
    private String market_cap;

    private String content;
    private ArrayList<String> information;

    public JSONQuoteParser(String content){
        this.content=content;
    }

    public ArrayList<String> parse(){
        information = new ArrayList<String>();

        Pattern namePattern = Pattern.compile("\"name\":\\s\"(.*?)\",");
        Matcher nameMatcher = namePattern.matcher(content);
        nameMatcher.find();
        this.name=nameMatcher.group(1);
        information.add(this.name);

        Pattern symbolPattern = Pattern.compile("\"symbol\":\\s\"(.*?)\",");
        Matcher symbolMatcher = symbolPattern.matcher(content);
        symbolMatcher.find();
        this.symbol=symbolMatcher.group(1);
        information.add(this.symbol);

        Pattern circPattern = Pattern.compile("\"circulating_supply\":\\s(.*?),");
        Matcher circMatcher = circPattern.matcher(content);
        circMatcher.find();
        this.circ_supply=circMatcher.group(1);
        information.add(this.circ_supply);

        Pattern maxPattern = Pattern.compile("\"max_supply\":\\s(.*?),");
        Matcher maxMatcher = maxPattern.matcher(content);
        maxMatcher.find();
        this.max_supply=maxMatcher.group(1);
        information.add(this.max_supply);

        Pattern cmcPattern = Pattern.compile("\"cmc_rank\":\\s(.*?),");
        Matcher cmcMatcher = cmcPattern.matcher(content);
        cmcMatcher.find();
        this.cmc_rank=cmcMatcher.group(1);
        information.add(this.cmc_rank);

        Pattern pricePattern = Pattern.compile("\"price\":\\s(.*?),");
        Matcher priceMatcher = pricePattern.matcher(content);
        priceMatcher.find();
        this.price=priceMatcher.group(1);
        information.add(this.price);

        Pattern volume24hPattern = Pattern.compile("\"volume_24h\":\\s(.*?),");
        Matcher volume24hMatcher = volume24hPattern.matcher(content);
        volume24hMatcher.find();
        this.volume24h=volume24hMatcher.group(1);
        information.add(this.volume24h);

        Pattern percent1hPattern = Pattern.compile("\"percent_change_1h\":\\s(.*),");
        Matcher percent1hMatcher = percent1hPattern.matcher(content);
        percent1hMatcher.find();
        this.percent1h=percent1hMatcher.group(1);
        information.add(this.percent1h);

        Pattern percent24hPattern = Pattern.compile("\"percent_change_24h\":\\s(.*),");
        Matcher percent24hMatcher = percent24hPattern.matcher(content);
        percent24hMatcher.find();
        this.percent24h=percent24hMatcher.group(1);
        information.add(this.percent24h);

        Pattern percent7dPattern = Pattern.compile("\"percent_change_7d\":\\s(.*),");
        Matcher percent7dMatcher = percent7dPattern.matcher(content);
        percent7dMatcher.find();
        this.percent7d=percent7dMatcher.group(1);
        information.add(this.percent7d);

        Pattern marketcapPattern = Pattern.compile("\"market_cap\":\\s(.*),");
        Matcher marketcapMatcher = marketcapPattern.matcher(content);
        marketcapMatcher.find();
        this.market_cap=marketcapMatcher.group(1);
        information.add(this.market_cap);

        return this.information;

    }


}
