package com.example.doisoat.common.until;

public class ExceptionConfig {

    public class SUCCESS{
        public static final String REPONSECODE = "EXT-0000";
        public static final String REPONSEMESSAGE = "Thanh Cong";
    }


    public class ERROR{
        public static final String REPONSECODE = "EXT-9999";
        public static final String REPONSEMESSAGE = "That Bai";
    }

    public class VALIDATED{
        public static final String REPONSECODE = "EXT-0023";
        public static final String REPONSEMESSAGE = "Thiếu file";
    }

    public class FILE_TYPE{
        public static final String REPONSECODE = "EXT-0032";
        public static final String REPONSEMESSAGE = "Sai định dạng file";
    }
}
