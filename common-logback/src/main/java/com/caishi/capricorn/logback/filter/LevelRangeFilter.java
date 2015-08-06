package com.caishi.capricorn.logback.filter;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.AbstractMatcherFilter;
import ch.qos.logback.core.spi.FilterReply;

/**
 * Created by apple on 15/8/6.
 * <p/>
 * level range filter
 */
public class LevelRangeFilter extends AbstractMatcherFilter<ILoggingEvent> {

	Level minLevel;

	Level maxLevel;

	public Level getMinLevel() {
		return minLevel;
	}

	public void setMinLevel(Level minLevel) {
		this.minLevel = minLevel;
	}

	public Level getMaxLevel() {
		return maxLevel;
	}

	public void setMaxLevel(Level maxLevel) {
		this.maxLevel = maxLevel;
	}

	public void start() {
		if (this.minLevel != null &&
				this.maxLevel != null &&
				this.maxLevel.isGreaterOrEqual(this.minLevel)) {
			super.start();
		} else {
			addError("The min level is " + minLevel + "; The max level is " + maxLevel);
		}
	}

	@Override
	public FilterReply decide(ILoggingEvent event) {
		if (!isStarted()) {
			return FilterReply.NEUTRAL;
		}

		if (event.getLevel().isGreaterOrEqual(minLevel) &&
				(maxLevel.isGreaterOrEqual(event.getLevel()))) {
			return onMatch;
		} else {
			return onMismatch;
		}
	}


}
