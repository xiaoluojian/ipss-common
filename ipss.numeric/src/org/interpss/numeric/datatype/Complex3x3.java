package org.interpss.numeric.datatype;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.linear.Array2DRowFieldMatrix;
import org.apache.commons.math3.linear.FieldMatrix;
import org.apache.commons.math3.linear.MatrixUtils;

public class Complex3x3 {
	
	private static final long serialVersionUID = 1;
	
	private static final Complex a = new Complex(-0.5, Math.sqrt(3)/2);
	public static final Complex[][] T120_abc = new Complex[][]{
			{new Complex(1,0),new Complex(1,0),new Complex(1,0)},
			{a.multiply(a),      a            ,new Complex(1,0)},
			{a,               a.multiply(a)   ,new Complex(1,0)}};
	
	 public static final Complex[][] Tabc_120 = new Complex[][]{
			{new Complex(1.0/3,0), a.divide(3)              ,a.multiply(a).divide(3)},
			{new Complex(1.0/3,0), a.multiply(a).divide(3)  ,a.divide(3)},
			{new Complex(1.0/3,0), new Complex(1.0/3,0)       ,new Complex(1.0/3,0)}};
	 
	 public static Array2DRowFieldMatrix fmT012_abc = new Array2DRowFieldMatrix(Tabc_120);
	 public static Array2DRowFieldMatrix fmTabc_120= new Array2DRowFieldMatrix(Tabc_120);

	public  Complex 
		aa = new Complex(0.0, 0.0), 
		ab = new Complex(0.0, 0.0),
		ac = new Complex(0.0, 0.0),
		
		ba = new Complex(0.0, 0.0), 
		bb = new Complex(0.0, 0.0),
		bc = new Complex(0.0, 0.0),
		
		ca = new Complex(0.0, 0.0), 
		cb = new Complex(0.0, 0.0),
		cc = new Complex(0.0, 0.0);
	
	public Complex3x3(){
		
	}
	
	public Complex3x3(Complex selfZorY, Complex mutualZorY){
		this.aa = selfZorY; bb = selfZorY; cc = selfZorY;
		ab= mutualZorY; ac= mutualZorY;
		ba= mutualZorY; bc= mutualZorY;
		ca= mutualZorY; cb= mutualZorY;
	}
	
	public Complex3x3(Complex pos,Complex neg, Complex zero){
		
		aa = pos;
		bb = neg;
		cc = zero;

	}
	
	public Complex3x3(Complex[][] cplxAry3x3){
		if(cplxAry3x3.length!=3 || cplxAry3x3[0].length!=3)
			try {
				throw new Exception("Input Complex array is not a 3 by 3 matrix");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else{
		this.aa = cplxAry3x3[0][0];
		this.ab = cplxAry3x3[0][1];
		this.ac = cplxAry3x3[0][2];
		
		
		this.ba = cplxAry3x3[1][0];
		this.bb = cplxAry3x3[1][1];
		this.bc = cplxAry3x3[1][2];
		
		this.ca = cplxAry3x3[2][0];
		this.cb = cplxAry3x3[2][1];
		this.cc = cplxAry3x3[2][2];
		
		}
		
	}
	

	
	public  Complex3x3 add(final Complex3x3 m3x3){
		
		 Complex3x3 cplxM3x3 = new  Complex3x3();
		 cplxM3x3.aa = this.aa.add(m3x3.aa);
		 cplxM3x3.ab = this.ab.add(m3x3.ab);
		 cplxM3x3.ac = this.ac.add(m3x3.ac);
		 
		 
		 cplxM3x3.ba = this.ba.add(m3x3.ba);
		 cplxM3x3.bb = this.bb.add(m3x3.bb);
		 cplxM3x3.bc = this.bc.add(m3x3.bc);
		 
		 
		 cplxM3x3.ca = this.ca.add(m3x3.ca);
		 cplxM3x3.cb = this.cb.add(m3x3.cb);
		 cplxM3x3.cc = this.cc.add(m3x3.cc);
				 
		return cplxM3x3;
		
	}
	
    public  Complex3x3 subtract(final Complex3x3 m3x3){
    	
		 Complex3x3 cplxM3x3 = new  Complex3x3();
		 cplxM3x3.aa = this.aa.subtract(m3x3.aa);
		 cplxM3x3.ab = this.ab.subtract(m3x3.ab);
		 cplxM3x3.ac = this.ac.subtract(m3x3.ac);
		 
		 
		 cplxM3x3.ba = this.ba.subtract(m3x3.ba);
		 cplxM3x3.bb = this.bb.subtract(m3x3.bb);
		 cplxM3x3.bc = this.bc.subtract(m3x3.bc);
		 
		 
		 cplxM3x3.ca = this.ca.subtract(m3x3.ca);
		 cplxM3x3.cb = this.cb.subtract(m3x3.cb);
		 cplxM3x3.cc = this.cc.subtract(m3x3.cc);
		return cplxM3x3;
		
	}
    
    public  Complex3x3 mulitply(final Complex3x3 m3x3){
    	
    	 Complex3x3 cplxM3x3 = new  Complex3x3();
    	 cplxM3x3.aa = this.aa.multiply(m3x3.aa).add(this.ab.multiply(m3x3.ba)).add(this.ac.multiply(m3x3.ca));
    	 cplxM3x3.ab = this.aa.multiply(m3x3.ab).add(this.ab.multiply(m3x3.bb)).add(this.ac.multiply(m3x3.cb));
    	 cplxM3x3.ac = this.aa.multiply(m3x3.ac).add(this.ab.multiply(m3x3.bc)).add(this.ac.multiply(m3x3.cc));
    	 
    	 
    	 cplxM3x3.ba = this.ba.multiply(m3x3.aa).add(this.bb.multiply(m3x3.ba)).add(this.bc.multiply(m3x3.ca));
    	 cplxM3x3.bb = this.ba.multiply(m3x3.ab).add(this.bb.multiply(m3x3.bb)).add(this.bc.multiply(m3x3.cb));
    	 cplxM3x3.bc = this.ba.multiply(m3x3.ac).add(this.bb.multiply(m3x3.bc)).add(this.bc.multiply(m3x3.cc));
    	 
    	 
    	 cplxM3x3.ca = this.ca.multiply(m3x3.aa).add(this.cb.multiply(m3x3.ba)).add(this.cc.multiply(m3x3.ca));
    	 cplxM3x3.cb = this.ca.multiply(m3x3.ab).add(this.cb.multiply(m3x3.bb)).add(this.cc.multiply(m3x3.cb));
    	 cplxM3x3.cc = this.ca.multiply(m3x3.ac).add(this.cb.multiply(m3x3.bc)).add(this.cc.multiply(m3x3.cc));
    	 
		return cplxM3x3;
		
   	}
    
    public  Complex3x3 To120(){
    	return new Complex3x3( Tabc_120).mulitply(this).mulitply(new Complex3x3( T120_abc));
		
   	}
    
    public Complex3x3 ToAbc(){
    	return new Complex3x3(T120_abc).mulitply(this).mulitply(new Complex3x3(Tabc_120 ));
    }
    
    /**
     * Zs = T^-1*Zp*T
     * @param abc
     * @return
     */
	public  static Complex3x3 abc_to_120(final Complex3x3 abc) {
		return new Complex3x3( Tabc_120).mulitply(abc).mulitply(new Complex3x3( T120_abc));
	}
	
	public static Complex3x3 z12_to_abc(final Complex3x3 z12) {
		return new Complex3x3( T120_abc).mulitply( z12).mulitply(new Complex3x3(Tabc_120 ));
	}
    
    public Complex[][] toComplex2DAry(){
    	Complex[][] cplx2D = new Complex[3][3];
    	
    	
    	return cplx2D;
    }
    
   
    
    
    
    

}
