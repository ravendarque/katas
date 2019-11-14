using FluentAssertions;
using NUnit.Framework;

namespace MarsRover.UnitTests
{
    internal class RotateRightCommandShould
    {
        [TestCase(Orientation.N, Orientation.E)]
        [TestCase(Orientation.E, Orientation.S)]
        [TestCase(Orientation.S, Orientation.W)]
        [TestCase(Orientation.W, Orientation.N)]
        public void RotateToNextOrientationOnLCommand(Orientation testOrientation, Orientation expectedOrientation)
        {
            const int dummyX = 1;
            const int dummyY = 1;
            var testPosition = new Position(dummyX, dummyY, testOrientation);
            const int testGridSizeX = 3;
            const int testGridSizeY = 3;
            var testTrackingModule = new TrackingModule
            {
                GridMaximumX = testGridSizeX,
                GridMaximumY = testGridSizeY,
                Position = testPosition
            };

            var spyCommand = new SpyCommand();
            var rotateCommand = new RotateRightCommand(spyCommand);
            rotateCommand.Execute(testTrackingModule);

            var actualTrackingModule = spyCommand.TrackingModule;

            actualTrackingModule.Position.Orientation.Should().Be(expectedOrientation);
        }
    }
}