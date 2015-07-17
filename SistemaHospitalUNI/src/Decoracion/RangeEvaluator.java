/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decoracion;

import com.toedter.calendar.DateUtil;
import com.toedter.calendar.IDateEvaluator;
import com.toedter.calendar.MinMaxDateEvaluator;
import java.awt.Color;
import java.util.Date;

/**
 *
 * @author crdzbird
 */
public class RangeEvaluator extends MinMaxDateEvaluator implements IDateEvaluator {

    private DateUtil dateUtil = new DateUtil();

    @Override
    public boolean isSpecial(Date date) {
        return false;
    }

    @Override
    public Color getSpecialForegroundColor() {
        return null;
    }

    @Override
    public Color getSpecialBackroundColor() {
        return null;
    }

    @Override
    public String getSpecialTooltip() {
        return null;
    }

    @Override
    public boolean isInvalid(Date date) {
        return dateUtil.checkDate(date);
        // if the given date is in the range then is invalid
    }

    /**
     * Sets the initial date in the range to be validated.
     *
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        dateUtil.setMinSelectableDate(startDate);
    }

    /**
     * @return the initial date in the range to be validated.
     */
    public Date getStartDate() {
        return dateUtil.getMinSelectableDate();
    }

    /**
     * Sets the final date in the range to be validated.
     *
     * @param endDate
     */
    public void setEndDate(Date endDate) {
        dateUtil.setMaxSelectableDate(endDate);
    }

    /**
     * @return the final date in the range to be validated.
     */
    public Date getEndDate() {
        return dateUtil.getMaxSelectableDate();
    }

    @Override
    public String getInvalidTooltip() {
        return null;
    }

    @Override
    public Color getInvalidBackroundColor() {
        return Color.BLACK;
    }

    @Override
    public Color getInvalidForegroundColor() {
        return Color.BLUE;
    }

}
