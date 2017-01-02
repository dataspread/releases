/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */

package org.zkoss.poi.ss.formula.eval;

import org.zkoss.poi.ss.formula.atp.AnalysisToolPak;
import org.zkoss.poi.ss.formula.function.FunctionMetadata;
import org.zkoss.poi.ss.formula.function.FunctionMetadataRegistry;
import org.zkoss.poi.ss.formula.functions.*;

import java.util.Collection;
import java.util.Collections;
import java.util.TreeSet;

/**
 * @author Amol S. Deshmukh &lt; amolweb at ya hoo dot com &gt;
 */
public final class FunctionEval {
	/**
	 * Some function IDs that require special treatment
	 */
	private static final class FunctionID {
		/** 1 */
		public static final int IF = FunctionMetadataRegistry.FUNCTION_INDEX_IF;
		/** 4 */
		public static final int SUM = FunctionMetadataRegistry.FUNCTION_INDEX_SUM;
		/** 78 */
		public static final int OFFSET = 78;
		/** 100 */
		public static final int CHOOSE = FunctionMetadataRegistry.FUNCTION_INDEX_CHOOSE;
		/** 148 */
		public static final int INDIRECT = FunctionMetadataRegistry.FUNCTION_INDEX_INDIRECT;
		/** 255 */
		public static final int EXTERNAL_FUNC = FunctionMetadataRegistry.FUNCTION_INDEX_EXTERNAL;
	}
	// convenient access to namespace
	private static final FunctionID ID = null;

	/**
	 * Array elements corresponding to unimplemented functions are <code>null</code>
	 */
	protected static final Function[] functions = produceFunctions();

	private static Function[] produceFunctions() {
		Function[] retval = new Function[368];

		retval[0] = new Count();
		retval[ID.IF] = new IfFunc();
		retval[2] = LogicalFunction.ISNA;
		retval[3] = LogicalFunction.ISERROR;
		retval[ID.SUM] = AggregateFunction.SUM;
		retval[5] = AggregateFunction.AVERAGE;
		retval[6] = AggregateFunction.MIN;
		retval[7] = AggregateFunction.MAX;
		retval[8] = new RowFunc(); // ROW
		retval[9] = new Column();
		retval[10] = new Na();
		retval[11] = new Npv();
		retval[12] = AggregateFunction.STDEV;
		retval[13] = NumericFunction.DOLLAR;

		retval[15] = NumericFunction.SIN;
		retval[16] = NumericFunction.COS;
		retval[17] = NumericFunction.TAN;
		retval[18] = NumericFunction.ATAN;
		retval[19] = NumericFunction.PI;
		retval[20] = NumericFunction.SQRT;
		retval[21] = NumericFunction.EXP;
		retval[22] = NumericFunction.LN;
		retval[23] = NumericFunction.LOG10;
		retval[24] = NumericFunction.ABS;
		retval[25] = NumericFunction.INT;
		retval[26] = NumericFunction.SIGN;
		retval[27] = NumericFunction.ROUND;
		retval[28] = new Lookup();
		retval[29] = new Index();

		retval[31] = TextFunction.MID;
		retval[32] = TextFunction.LEN;
		retval[33] = new Value();
		retval[34] = BooleanFunction.TRUE;
		retval[35] = BooleanFunction.FALSE;
		retval[36] = BooleanFunction.AND;
		retval[37] = BooleanFunction.OR;
		retval[38] = BooleanFunction.NOT;
		retval[39] = NumericFunction.MOD;

		retval[46] = AggregateFunction.VAR;
		retval[48] = TextFunction.TEXT;

		retval[56] = FinanceFunction.PV;
		retval[57] = FinanceFunction.FV;
		retval[58] = FinanceFunction.NPER;
		retval[59] = FinanceFunction.PMT;

      retval[60] = new Rate();
		retval[62] = new Irr();
		retval[63] = NumericFunction.RAND;
		retval[64] = new Match();
		retval[65] = DateFunc.instance;
		retval[66] = new TimeFunc();
		retval[67] = CalendarFieldFunction.DAY;
		retval[68] = CalendarFieldFunction.MONTH;
		retval[69] = CalendarFieldFunction.YEAR;

		retval[70] = WeekdayFunc.instance;
		retval[71] = CalendarFieldFunction.HOUR;
		retval[72] = CalendarFieldFunction.MINUTE;
		retval[73] = CalendarFieldFunction.SECOND;
		retval[74] = new Now();

		retval[76] = new Rows();
		retval[77] = new Columns();
		retval[82] = TextFunction.SEARCH;
		retval[ID.OFFSET] = new Offset();
		retval[82] = TextFunction.SEARCH;

		retval[97] = NumericFunction.ATAN2;
		retval[98] = NumericFunction.ASIN;
		retval[99] = NumericFunction.ACOS;
		retval[ID.CHOOSE] = new Choose();
		retval[101] = new Hlookup();
		retval[102] = new Vlookup();

		retval[105] = LogicalFunction.ISREF;

		retval[109] = NumericFunction.LOG;

        retval[111] = TextFunction.CHAR;
		retval[112] = TextFunction.LOWER;
		retval[113] = TextFunction.UPPER;

		retval[115] = TextFunction.LEFT;
		retval[116] = TextFunction.RIGHT;
		retval[117] = TextFunction.EXACT;
		retval[118] = TextFunction.TRIM;
		retval[119] = new Replace();
		retval[120] = new Substitute();

		retval[124] = TextFunction.FIND;

		retval[127] = LogicalFunction.ISTEXT;
		retval[128] = LogicalFunction.ISNUMBER;
		retval[129] = LogicalFunction.ISBLANK;
		retval[130] = new T();

		retval[ID.INDIRECT] = null; // Indirect.evaluate has different signature
        retval[162] = TextFunction.CLEAN;  //Aniket Banerjee    
		retval[169] = new Counta();

		retval[183] = AggregateFunction.PRODUCT;
		retval[184] = NumericFunction.FACT;

		retval[190] = LogicalFunction.ISNONTEXT;
        retval[194] = AggregateFunction.VARP;
		retval[197] = NumericFunction.TRUNC;
		retval[198] = LogicalFunction.ISLOGICAL;

		retval[212] = NumericFunction.ROUNDUP;
		retval[213] = NumericFunction.ROUNDDOWN;
        retval[216] = new Rank();
        retval[219] = new Address();  //Aniket Banerjee
        retval[220] = new Days360();
		retval[221] = new Today();

		retval[227] = AggregateFunction.MEDIAN;
		retval[228] = new Sumproduct();
		retval[229] = NumericFunction.SINH;
		retval[230] = NumericFunction.COSH;
		retval[231] = NumericFunction.TANH;
		retval[232] = NumericFunction.ASINH;
		retval[233] = NumericFunction.ACOSH;
		retval[234] = NumericFunction.ATANH;

		retval[ID.EXTERNAL_FUNC] = null; // ExternalFunction is a FreeREfFunction

		retval[261] = new Errortype();

		retval[269] = AggregateFunction.AVEDEV;

		retval[276] = NumericFunction.COMBIN;

		retval[279] = new Even();

		retval[285] = NumericFunction.FLOOR;

		retval[288] = NumericFunction.CEILING;

		retval[298] = new Odd();

        retval[300] = NumericFunction.POISSON;

		retval[303] = new Sumxmy2();
		retval[304] = new Sumx2my2();
		retval[305] = new Sumx2py2();

		retval[318] = AggregateFunction.DEVSQ;

		retval[321] = AggregateFunction.SUMSQ;

		retval[325] = AggregateFunction.LARGE;
		retval[326] = AggregateFunction.SMALL;

		retval[330] = new Mode();

		retval[336] = TextFunction.CONCATENATE;
		retval[337] = NumericFunction.POWER;

		retval[342] = NumericFunction.RADIANS;
		retval[343] = NumericFunction.DEGREES;

		retval[344] = new Subtotal();
		retval[345] = new Sumif();
		retval[346] = new Countif();
		retval[347] = new Countblank();

		retval[359] = new Hyperlink();

		retval[362] = MinaMaxa.MAXA;
		retval[363] = MinaMaxa.MINA;

		for (int i = 0; i < retval.length; i++) {
			//20130927, dennischen@zkoss.org, support to override basic function
//			Function f = retval[i];
//			if (f == null) {
//				FunctionMetadata fm = FunctionMetadataRegistry.getFunctionByIndex(i);
//				if (fm == null) {
//					continue;
//				}
//				retval[i] = new NotImplementedFunction(fm.getName());
//			}

			FunctionMetadata fm = FunctionMetadataRegistry.getFunctionByIndex(i);
			if(fm==null)
				continue;
			if (retval[i] == null) {
				retval[i] = new NotImplementedFunction(fm.getName());
			}
			retval[i] = new OverridableFunction(fm.getName(),retval[i]);
			
		}
		return retval;
	}
	/**
	 * @return <code>null</code> if the specified functionIndex is for INDIRECT() or any external (add-in) function.
	 */
	public static Function getBasicFunction(int functionIndex) {
		// check for 'free ref' functions first
		switch (functionIndex) {
			case FunctionID.INDIRECT:
			case FunctionID.EXTERNAL_FUNC:
				return null;
		}
		// else - must be plain function
		Function result = functions[functionIndex];
		if (result == null) {
			throw new NotImplementedException("FuncIx=" + functionIndex);
		}
		return result;
	}

    /**
     * Register a new function in runtime.
     *
     * @param name  the function name
     * @param func  the functoin to register
     * @throws IllegalArgumentException if the function is unknown or already  registered.
     * @since 3.8 beta6
     */
    public static void registerFunction(String name, Function func){
        FunctionMetadata metaData = FunctionMetadataRegistry.getFunctionByName(name);
        if(metaData == null) {
            if(AnalysisToolPak.isATPFunction(name)) {
                throw new IllegalArgumentException(name + " is a function from the Excel Analysis Toolpack. " +
                        "Use AnalysisToolpack.registerFunction(String name, FreeRefFunction func) instead.");
            } else {
                throw new IllegalArgumentException("Unknown function: " + name);
            }
        }

        int idx = metaData.getIndex();
        if(functions[idx] instanceof NotImplementedFunction) {
            functions[idx] = func;
        } else {
            throw new IllegalArgumentException("POI already implememts " + name +
                    ". You cannot override POI's implementations of Excel functions");
        }
    }

    /**
     * Returns a collection of function names implemented by POI.
     *
     * @return an array of supported functions
     * @since 3.8 beta6
     */
    public static Collection<String> getSupportedFunctionNames(){
        Collection<String> lst = new TreeSet<String>();
        for(int i = 0; i < functions.length; i++){
            Function func = functions[i];
            FunctionMetadata metaData = FunctionMetadataRegistry.getFunctionByIndex(i);
            if(func != null && !(func instanceof NotImplementedFunction)){
                lst.add(metaData.getName());
            }
        }
        lst.add("INDIRECT"); // INDIRECT is a special case
        return Collections.unmodifiableCollection(lst);
    }

    /**
     * Returns an array of function names NOT implemented by POI.
     *
     * @return an array of not supported functions
     * @since 3.8 beta6
     */
    public static Collection<String> getNotSupportedFunctionNames(){
        Collection<String> lst = new TreeSet<String>();
        for(int i = 0; i < functions.length; i++){
            Function func = functions[i];
            if(func != null && (func instanceof NotImplementedFunction)){
                FunctionMetadata metaData = FunctionMetadataRegistry.getFunctionByIndex(i);
                lst.add(metaData.getName());
            }
        }
        lst.remove("INDIRECT"); // INDIRECT is a special case
        return Collections.unmodifiableCollection(lst);
    }
}
