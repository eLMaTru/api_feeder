<<<<<<< HEAD
package com.hht.api.feeder.constants;


/**
 * This class contains validation patterns
 * 
 * @author Jorge De Los Santos
 * @Version 1.1
 * @Since May 5, 2019 
 */
public class ValidationPattern {
	
	/** The Constant GUI_PATTERN. */
	public static final String UUID_PATTERN = "^[0-9a-fA-F]{8}[0-9a-fA-F]{4}[0-9a-fA-F]{4}[0-9a-fA-F]{4}[0-9a-fA-F]{12}$";
	
	/** The Constant ONLY_NUMBER_PATTERN. */
	public static final String ONLY_NUMBER_PATTERN  = "\\d+";
    
    /** The Constant ONLY_LETTERS_PATTERN. */
    public static final String ONLY_LETTERS_PATTERN  = "[A-Za-z]*";
    
    /** The Constant EMAIL_PATTERN. */
    public static final String EMAIL_PATTERN = "^[_a-z0-9-]+(.[a-z0-9-]+)@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$";
    
    /** The Constant CAPITAL_LETTERS_PATTERN. */
    public static final String CAPITAL_LETTERS_PATTERN = "(?!^.*[A-Z]{2,}.*$)^[A-Za-z]*$";
    
    /** The Constant PHONE_PATTERN. */
    public static final String PHONE_PATTERN = "(^$|[0-9]{10})";

}
=======
package com.hht.api.feeder.constants;


/**
 * This class contains validation patterns
 * 
 * @author Jorge De Los Santos
 * @Version 1.1
 * @Since May 5, 2019 
 */
public class ValidationPattern {
	
	/** The Constant GUI_PATTERN. */
	public static final String UUID_PATTERN = "^[0-9a-fA-F]{8}[0-9a-fA-F]{4}[0-9a-fA-F]{4}[0-9a-fA-F]{4}[0-9a-fA-F]{12}$";
	
	/** The Constant ONLY_NUMBER_PATTERN. */
	public static final String ONLY_NUMBER_PATTERN  = "\\d+";
    
    /** The Constant ONLY_LETTERS_PATTERN. */
    public static final String ONLY_LETTERS_PATTERN  = "[A-Za-z]*";
    
    /** The Constant EMAIL_PATTERN. */
    public static final String EMAIL_PATTERN = "^[_a-z0-9-]+(.[a-z0-9-]+)@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$";
    
    /** The Constant CAPITAL_LETTERS_PATTERN. */
    public static final String CAPITAL_LETTERS_PATTERN = "(?!^.*[A-Z]{2,}.*$)^[A-Za-z]*$";
    
    /** The Constant PHONE_PATTERN. */
    public static final String PHONE_PATTERN = "(^$|[0-9]{10})";

}
>>>>>>> branch 'master' of https://eLMatru@bitbucket.org/horizon-h-t/api_feeder.git
