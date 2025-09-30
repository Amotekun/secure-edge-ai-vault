#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_sentraedgevaultdemo_MainActivity_stringFromVault(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++ Secure Edge Vault";
    return env->NewStringUTF(hello.c_str());  // <-- Corrected here
}

// New JNI function
extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_sentraedgevaultdemo_MainActivity_getDeviceMessage (
        JNIEnv* env,
        jobject /* this */
        ) {
    std::string msg = "JNI is working with multiple calls!";
    return env->NewStringUTF(msg.c_str());
}