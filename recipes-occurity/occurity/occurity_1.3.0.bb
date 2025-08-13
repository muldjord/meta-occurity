SUMMARY = "Recipe for Occurity visual acuity software"
DESCRIPTION = "Recipe for building and installing the Occurity visual acuity software"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0-only;md5=c79ff39f19dfec6d293b95dea7b07891"

SRC_URI = "git://github.com/muldjord/occurity.git;branch=qt6;protocol=https"
PV = "1.3.0+git${SRCPV}"
SRCREV = "60c198d1375165dd1eb760dc75881c77a2742bb0"

DEPENDS += " bash qtbase qtmultimedia qtsvg ffmpeg"
RDEPENDS:${PN} += " bash"

S = "${WORKDIR}/git"

do_install:append() {
  # Install the application
  install -d ${D}/home/root/occurity/
  install -m 0755 release/Occurity ${D}/home/root/occurity/
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
