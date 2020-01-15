package mathmodule;

import java.math.BigDecimal;

import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

import mathmodule.proxies.ExpressionResult;

public class Misc {
	
	public static final double MAX_DECIMAL_VALUE = Math.pow(10, 20) - 1;
	public static final double MAX_INT_VALUE = Math.pow(2, 31) - 1;
	public static final double MAX_LONG_VALUE = Math.pow(2, 63) - 1;
	
	public static IMendixObject getExpressionResult(IContext ctx, double value) {
		IMendixObject result = Core.instantiate(ctx, ExpressionResult.getType());
		
		String attrIsValid = ExpressionResult.MemberNames.IsValid.toString();
		String attrValue = ExpressionResult.MemberNames.Value.toString();
		String attrStringValue = ExpressionResult.MemberNames.StringValue.toString();
		String attrHasDecimal = ExpressionResult.MemberNames.HasDecimal.toString();

		result.setValue(ctx, attrIsValid, true);
		result.setValue(ctx, attrStringValue, String.format("%.16f", value));
		
		if (value > MAX_DECIMAL_VALUE || value < (0 - MAX_DECIMAL_VALUE)) {
			result.setValue(ctx, attrHasDecimal, false);
			result.setValue(ctx, attrValue, null);
		} else {
			result.setValue(ctx, attrHasDecimal, true);
			result.setValue(ctx, attrValue, new BigDecimal(value));
		}
		
		
		return result;
	}
	
	public static IMendixObject getExpressionError(IContext ctx, String error) {
		IMendixObject result = Core.instantiate(ctx, ExpressionResult.getType());
		
		String attrIsValid = ExpressionResult.MemberNames.IsValid.toString();
		String attrError = ExpressionResult.MemberNames.ErrorMessage.toString();

		result.setValue(ctx, attrIsValid, false);
		result.setValue(ctx, attrError, error);
		
		return result;
	}
}