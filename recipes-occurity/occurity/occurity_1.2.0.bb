SUMMARY = "Recipe for Occurity visual acuity software"
DESCRIPTION = "Recipe for building and installing the Occurity visual acuity software"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0-only;md5=c79ff39f19dfec6d293b95dea7b07891"

SRC_URI = "git://github.com/muldjord/occurity.git;branch=master;protocol=https"
PV = "1.2.0+git${SRCPV}"
SRCREV = "7a3dfae618c22187f904c130fe1f5da550f381b8"

DEPENDS += " bash qtbase qtmultimedia qtsvg gstreamer1.0-libav"
RDEPENDS:${PN} += " bash"

S = "${WORKDIR}/git"

do_install:append() {
  # Install the application
  install -d ${D}/home/root/occurity/
  install -m 0755 Occurity ${D}/home/root/occurity/
  install -m 0664 ${S}/AUTHORS ${D}/home/root/occurity/
  install -m 0664 ${S}/charts.xml.example ${D}/home/root/occurity/
  install -m 0664 ${S}/LICENSE ${D}/home/root/occurity/
  install -m 0664 ${S}/occurity_da_DK.qm ${D}/home/root/occurity/
  install -m 0664 ${S}/README.md ${D}/home/root/occurity/
  cp -R ${S}/optotypes ${D}/home/root/occurity/
  cp -R ${S}/docs ${D}/home/root/occurity/
  cp -R ${S}/flirc_configs ${D}/home/root/occurity/
  cp -R ${S}/scripts ${D}/home/root/occurity/
  cp -R ${S}/jobs ${D}/home/root/occurity/
  cp -R ${S}/svg ${D}/home/root/occurity/
  cp -R ${S}/videos ${D}/home/root/occurity/
}

FILES:${PN} += "/home/root/occurity/"

# Inherit the qmake5 class to build the application
inherit qmake5
