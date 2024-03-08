SUMMARY = "Installs Occurity and adjusts Matchbox configuration"
DESCRIPTION = "Copies Occurity application files into rootfs, adjusts the Matchbox configuration and set Occurity to autostart"
LICENSE = "MIT"

SAVED_DIR := "${THISDIR}"

do_matchbox_adjust() {
  cp ${SAVED_DIR}/session ${IMAGE_ROOTFS}/etc/matchbox/session
  cp ${SAVED_DIR}/occurity.desktop ${IMAGE_ROOTFS}/etc/xdg/autostart/
}

IMAGE_PREPROCESS_COMMAND += "do_matchbox_adjust"
