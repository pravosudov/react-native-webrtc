package org.webrtc;

import java.util.List;
import org.webrtc.CameraEnumerator;
import org.webrtc.CameraEnumerationAndroid.CaptureFormat;
import org.webrtc.CameraVideoCapturer.CameraEventsHandler;

public class UsbCameraEnumerator implements CameraEnumerator {

    private CameraEnumerator cameraEnumerator;

    public UsbCameraEnumerator(CameraEnumerator cameraEnumerator) {
        this.cameraEnumerator = cameraEnumerator;
    }

    @Override
    public String[] getDeviceNames() {
        String[] deviceNames = cameraEnumerator.getDeviceNames();
        String[] deviceNamesWithUsb = new String[deviceNames.length + 1];
        System.arraycopy(deviceNames, 0, deviceNamesWithUsb, 0, deviceNames.length);
        deviceNamesWithUsb[deviceNamesWithUsb.length - 1] = "USBUSBUSB";
        return deviceNamesWithUsb;
    }

    @Override
    public boolean isFrontFacing(String var1) {
        return cameraEnumerator.isFrontFacing(var1);
    }

    @Override
    public boolean isBackFacing(String var1) {
        return cameraEnumerator.isBackFacing(var1);
    }

    @Override
    public List<CaptureFormat> getSupportedFormats(String var1) {
        return cameraEnumerator.getSupportedFormats(var1);
    }

    @Override
    public CameraVideoCapturer createCapturer(String var1, CameraEventsHandler var2) {
        return cameraEnumerator.createCapturer(var1, var2);
    }
}
