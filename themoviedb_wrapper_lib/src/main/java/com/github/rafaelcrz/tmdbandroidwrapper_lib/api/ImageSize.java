package com.github.rafaelcrz.tmdbandroidwrapper_lib.api;

/**
 * Created by Rafael Felipe on 01/06/2017.
 */

public class ImageSize {

    public final static String BASE_URL = "http://image.tmdb.org/t/p/"; //Image base url

    public final static String SECURE_BASE_URL = "https://image.tmdb.org/t/p/"; //Image secure base url

    /**
     * Set the image size. Default is 'original'.
     *
     * @param path The image path (get from the model)
     * @param size The enum size like. ImageSize.Poster.W185
     * @return Image url with the new size.
     */
    public static String setImageSize(String path, Enum size) {
        return BASE_URL.concat(size.name().toLowerCase()).concat("/").concat(path);
    }

    //The defaults image sizes enum

    //It is used on movie detail
    public enum Backdrop {

        ORIGINAL(ImageSizeType.ORIGINAL_), W300(ImageSizeType.W300_), W780(ImageSizeType.W780_), W1280(ImageSizeType.W1280_);

        private String size;

        Backdrop(String w) {
            size = w;
        }

        public String getSize() {
            return size;
        }

    }

    //The image logo
    public enum Logo {

        ORIGINAL(ImageSizeType.ORIGINAL_), W45(ImageSizeType.W300_), W92(ImageSizeType.W780_), W154(ImageSizeType.W154_), W185(ImageSizeType.W185_), W300(ImageSizeType.W300_), W500(ImageSizeType.W500_);

        private String size;

        Logo(String w) {
            size = w;
        }

        public String getSize() {
            return size;
        }

    }

    //Its used for list the movies
    public enum Poster {

        ORIGINAL(ImageSizeType.ORIGINAL_), W154(ImageSizeType.W154_), W185(ImageSizeType.W185_), W342(ImageSizeType.W342_), W500(ImageSizeType.W500_), W780(ImageSizeType.W780_);

        private String size;

        Poster(String w) {
            size = w;
        }

        public String getSize() {
            return size;
        }

    }

    //User profile
    public enum Profile {

        ORIGINAL(ImageSizeType.ORIGINAL_), W45(ImageSizeType.W45_), W185(ImageSizeType.W185_), W300(ImageSizeType.W300_);

        private String size;

        Profile(String w) {
            size = w;
        }

        public String getSize() {
            return size;
        }

    }

    //Still image
    public enum Still {

        ORIGINAL(ImageSizeType.ORIGINAL_), W92(ImageSizeType.W92_), W185(ImageSizeType.W185_), W300(ImageSizeType.W300_);

        private String size;

        Still(String w) {
            size = w;
        }

        public String getSize() {
            return size;
        }

    }


    public enum ChangeKeys {

    }
}