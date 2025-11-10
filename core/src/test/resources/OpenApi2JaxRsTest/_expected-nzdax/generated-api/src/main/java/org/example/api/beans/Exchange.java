
package org.example.api.beans;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Exchange {

    _1BTCXE("_1btcxe"),
    ACX("acx"),
    ALLCOIN("allcoin"),
    ANXPRO("anxpro"),
    ANYBITS("anybits"),
    BCEX("bcex"),
    BEQUANT("bequant"),
    BIBOX("bibox"),
    BIGONE("bigone"),
    BINANCE("binance"),
    BINANCEJE("binanceje"),
    BIT2C("bit2c"),
    BITBANK("bitbank"),
    BITBAY("bitbay"),
    BITFINEX("bitfinex"),
    BITFINEX2("bitfinex2"),
    BITFLYER("bitflyer"),
    BITFOREX("bitforex"),
    BITHUMB("bithumb"),
    BITIBU("bitibu"),
    BITKK("bitkk"),
    BITLISH("bitlish"),
    BITMARKET("bitmarket"),
    BITMEX("bitmex"),
    BITSANE("bitsane"),
    BITSO("bitso"),
    BITSTAMP("bitstamp"),
    BITSTAMP1("bitstamp1"),
    BITTREX("bittrex"),
    BITZ("bitz"),
    BL3P("bl3p"),
    BLEUTRADE("bleutrade"),
    BRAZILIEX("braziliex"),
    BTCALPHA("btcalpha"),
    BTCBOX("btcbox"),
    BTCCHINA("btcchina"),
    BTCEXCHANGE("btcexchange"),
    BTCMARKETS("btcmarkets"),
    BTCTRADEIM("btctradeim"),
    BTCTRADEUA("btctradeua"),
    BTCTURK("btcturk"),
    BUDA("buda"),
    BXINTH("bxinth"),
    CCEX("ccex"),
    CEX("cex"),
    CHBTC("chbtc"),
    CHILEBIT("chilebit"),
    COBINHOOD("cobinhood"),
    COINBASE("coinbase"),
    COINBASEPRIME("coinbaseprime"),
    COINBASEPRO("coinbasepro"),
    COINCHECK("coincheck"),
    COINEGG("coinegg"),
    COINEX("coinex"),
    COINEXCHANGE("coinexchange"),
    COINFALCON("coinfalcon"),
    COINFLOOR("coinfloor"),
    COINGI("coingi"),
    COINMARKETCAP("coinmarketcap"),
    COINMATE("coinmate"),
    COINNEST("coinnest"),
    COINONE("coinone"),
    COINSPOT("coinspot"),
    COINTIGER("cointiger"),
    COOLCOIN("coolcoin"),
    COSS("coss"),
    CREX24("crex24"),
    CRYPTON("crypton"),
    CRYPTOPIA("cryptopia"),
    DERIBIT("deribit"),
    DSX("dsx"),
    ETHFINEX("ethfinex"),
    EXMO("exmo"),
    EXX("exx"),
    FCOIN("fcoin"),
    FCOINJP("fcoinjp"),
    FLOWBTC("flowbtc"),
    FOXBIT("foxbit"),
    FYBSE("fybse"),
    FYBSG("fybsg"),
    GATEIO("gateio"),
    GDAX("gdax"),
    GEMINI("gemini"),
    GETBTC("getbtc"),
    HADAX("hadax"),
    HITBTC("hitbtc"),
    HITBTC2("hitbtc2"),
    HUOBIPRO("huobipro"),
    HUOBIRU("huobiru"),
    ICE3X("ice3x"),
    INDEPENDENTRESERVE("independentreserve"),
    INDODAX("indodax"),
    ITBIT("itbit"),
    JUBI("jubi"),
    KKEX("kkex"),
    KRAKEN("kraken"),
    KUCOIN("kucoin"),
    KUCOIN2("kucoin2"),
    KUNA("kuna"),
    LAKEBTC("lakebtc"),
    LBANK("lbank"),
    LIQUI("liqui"),
    LIQUID("liquid"),
    LIVECOIN("livecoin"),
    LUNO("luno"),
    LYKKE("lykke"),
    MANDALA("mandala"),
    MERCADO("mercado"),
    MIXCOINS("mixcoins"),
    NEGOCIECOINS("negociecoins"),
    NOVA("nova"),
    OKCOINCNY("okcoincny"),
    OKCOINUSD("okcoinusd"),
    OKEX("okex"),
    PAYMIUM("paymium"),
    POLONIEX("poloniex"),
    QUADRIGACX("quadrigacx"),
    RIGHTBTC("rightbtc"),
    SOUTHXCHANGE("southxchange"),
    STRONGHOLD("stronghold"),
    SURBITCOIN("surbitcoin"),
    THEOCEAN("theocean"),
    THEROCK("therock"),
    TIDEBIT("tidebit"),
    TIDEX("tidex"),
    UEX("uex"),
    UPBIT("upbit"),
    URDUBIT("urdubit"),
    VAULTORO("vaultoro"),
    VBTC("vbtc"),
    VIRWOX("virwox"),
    XBTCE("xbtce"),
    YOBIT("yobit"),
    ZAIF("zaif"),
    ZB("zb");
    private final String value;
    private final static Map<String, Exchange> CONSTANTS = new HashMap<String, Exchange>();

    static {
        for (Exchange c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private Exchange(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

    @JsonCreator
    public static Exchange fromValue(String value) {
        Exchange constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
