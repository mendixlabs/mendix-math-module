package mathmodule;

import java.math.BigDecimal;

import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

import mathmodule.proxies.SimpleExpressionResult;
import mathmodule.proxies.ComplexExpressionResult;
import mathmodule.proxies.ExpressionResult;

public class Misc {
	
	public static final double MAX_DECIMAL_VALUE = Math.pow(10, 20) - 1;
	public static final double MAX_INT_VALUE = Math.pow(2, 31) - 1;
	public static final double MAX_LONG_VALUE = Math.pow(2, 63) - 1;
	
	public static IMendixObject getComplexExpressionResult(IContext ctx, double value) {
		IMendixObject result = Core.instantiate(ctx, ComplexExpressionResult.getType());
		
		String attrIsValid = ComplexExpressionResult.MemberNames.IsValid.toString();
		String attrValue = ComplexExpressionResult.MemberNames.Value.toString();
		String attrStringValue = ComplexExpressionResult.MemberNames.StringValue.toString();
		String attrHasDecimal = ComplexExpressionResult.MemberNames.HasDecimal.toString();
		
		return setExpressionResultObject(ctx, result, value, attrIsValid, attrStringValue, attrValue, attrHasDecimal);
	}
	
	public static IMendixObject getSimpleExpressionResult(IContext ctx, double value) {
		IMendixObject result = Core.instantiate(ctx, SimpleExpressionResult.getType());
		
		String attrIsValid = SimpleExpressionResult.MemberNames.IsValid.toString();
		String attrValue = SimpleExpressionResult.MemberNames.Value.toString();
		String attrStringValue = SimpleExpressionResult.MemberNames.StringValue.toString();
		String attrHasDecimal = SimpleExpressionResult.MemberNames.HasDecimal.toString();
		
		return setExpressionResultObject(ctx, result, value, attrIsValid, attrStringValue, attrValue, attrHasDecimal);
	}
	
	private static IMendixObject setExpressionResultObject(IContext ctx, IMendixObject result, double value, String attrIsValid, String attrStringValue, String attrValue, String attrHasDecimal) {
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
	
	public static IMendixObject getExpressionError(IContext ctx, String resultType, String error) {
		IMendixObject result = Core.instantiate(ctx, resultType);
		
		String attrIsValid = ExpressionResult.MemberNames.IsValid.toString();
		String attrError = ExpressionResult.MemberNames.ErrorMessage.toString();

		result.setValue(ctx, attrIsValid, false);
		result.setValue(ctx, attrError, error);
		
		return result;
	}
}