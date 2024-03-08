SUMMARY = "Recipe for Occurity visual acuity software"
DESCRIPTION = "Recipe for building the Occurity visual acuity software"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0-only;md5=c79ff39f19dfec6d293b95dea7b07891"

SRC_URI = "git://github.com/muldjord/occurity.git;branch=master;protocol=https"
PV = "1.1.0+git${SRCPV}"
SRCREV = "23c5bea788902e9d1c07c474d8c59a4d24c9ab67"

DEPENDS += " qtbase qtmultimedia qtsvg gstreamer1.0-libav "

S = "${WORKDIR}/git"

do_install:append() {
  # Install the application
  install -d ${D}/home/root/occurity/
  install -m 0755 Occurity ${D}/home/root/occurity/
}

FILES:${PN} += "/home/root/occurity/"

# Inherit the qmake5 class to build the application
inherit qmake5
