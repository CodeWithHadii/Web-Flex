# Add any ProGuard configurations specific to this
# extension here.

-keep public class com.devxlabs.webflex.WebFlex {
    public *;
 }
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 4
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'com/devxlabs/webflex/repack'
-flattenpackagehierarchy
-dontpreverify
