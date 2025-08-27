SUMMARY = "Adjusts Matchbox configuration and adds Occurity package"
DESCRIPTION = "Adjusts the Sato and Matchbox configuration, set Occurity to autostart and adds the Occurity package."
LICENSE = "MIT"

IMAGE_INSTALL:append = " occurity nano"

SAVED_DIR := "${THISDIR}"

do_matchbox_adjust() {
  cp ${SAVED_DIR}/session ${IMAGE_ROOTFS}/etc/matchbox/session
  cp ${SAVED_DIR}/occurity.desktop ${IMAGE_ROOTFS}/etc/xdg/autostart/
}

IMAGE_PREPROCESS_COMMAND += "do_matchbox_adjust"
