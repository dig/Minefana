package com.github.games647.minefana.common.collectors;

import com.github.games647.minefana.common.AnalyticsType;
import com.github.games647.minefana.common.InfluxConnector;

import java.util.function.DoubleSupplier;

public class TpsCollector extends AbstractCollector {

    private final DoubleSupplier collector;

    public TpsCollector(InfluxConnector connector, String serverTag, DoubleSupplier collector) {
        super(connector, serverTag);
        this.collector = collector;
    }

    @Override
    public void run() {
        double tps = round(collector.getAsDouble());
        send(AnalyticsType.TPS.newPoint().addField("tps", tps));
    }
}
