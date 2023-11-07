package converter.ejb;

import java.text.DecimalFormat;
import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;

/**
 *
 * @author HP
 */
@Stateless
@LocalBean
public class ConverterBean implements ConverterBeanLocal {

    private DecimalFormat twoDigits = new DecimalFormat("0.00");
    
    public String ctok(double c) {
        String result = twoDigits.format(((c+273.15)*100)/100.0);
        return result;
    }
    
    public String ktoc(float k) {
        String result = twoDigits.format(((k-273.15)*100)/100.0);
        return result;
    }
}
